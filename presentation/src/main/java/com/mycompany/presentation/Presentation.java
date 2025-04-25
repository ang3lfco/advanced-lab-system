/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.presentation;

import connection.DBConnection;
import daos.PatientDAO;
import interfaces.IDBConnection;
import interfaces.IPatientDAO;
import interfaces.IPatientService;
import javax.swing.JOptionPane;
import services.PatientService;
import ui.admin.frmHome;

/**
 *
 * @author ang3lfco
 */
public class Presentation {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try{
            IDBConnection conn = new DBConnection();
            IPatientDAO patientDAO = new PatientDAO(conn);
            IPatientService patientService = new PatientService(patientDAO);
            frmHome home = new frmHome(patientService);
            home.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }
}
