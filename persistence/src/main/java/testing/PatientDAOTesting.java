/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import connection.DBConnection;
import daos.PatientDAO;
import entities.Patient;
import interfaces.IDBConnection;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class PatientDAOTesting {
    public static void main(String[] args) {
        IDBConnection conn = new DBConnection();
        PatientDAO pdao = new PatientDAO(conn);
//        pdao.delete(3L);

//        Patient patient = pdao.read(4L);
//        patient.setFirstName("CarlosEdited");
//        patient.setGender("F");
//        pdao.update(patient);
//        Patient patient = pdao.read(4L);
//        patient.setFirstName("Carlos");
//        patient.setGender("M");
//        pdao.update(patient);
        
//        List<Patient> patients = pdao.getPatients();
//        for(Patient p : patients){
//            System.out.println(p);
//        }
        
//        Patient result = pdao.read(3L);
//        System.out.println(result);
        
//        Patient patient = new Patient(
//            "Carlos",
//            "Ramírez",
//            "M",
//            LocalDate.of(1988, Month.MARCH, 12),
//            "125 Maple Street, San Diego, CA",
//            "6195550246",
//            "carlos.ramirez@example.com",
//            new ArrayList<>()
//        );
//        
//        pdao.create(patient);
    }
}
