/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Patient;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface IPatientDAO {
    void create(Patient patient);
    Patient read(Long id);
    void update(Patient patient);
    void delete(Long id);
    List<Patient> getPatients();
}
