/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.PatientDTO;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface IPatientService {
    void registerPatient(PatientDTO patientDTO);
    List<PatientDTO> consultPatientList();
}
