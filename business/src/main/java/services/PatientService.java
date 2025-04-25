/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dtos.PatientDTO;
import entities.Patient;
import interfaces.IPatientDAO;
import interfaces.IPatientService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ang3lfco
 */
public class PatientService implements IPatientService{
    private IPatientDAO patientDAO;
    
    public PatientService(IPatientDAO patientDAO){
        this.patientDAO = patientDAO;
    }
    
    @Override
    public void registerPatient(PatientDTO patientDTO){
        Patient patient = new Patient(
                patientDTO.getFirstName(),
                patientDTO.getLastName(),
                patientDTO.getGender(),
                patientDTO.getBirthdate(),
                patientDTO.getAddress(),
                patientDTO.getPhoneNumber(),
                patientDTO.getEmail(),
                new ArrayList<>()
        );
        patientDAO.create(patient);
    }
    
    @Override
    public List<PatientDTO> consultPatientList(){
        List<Patient> patients = patientDAO.getPatients();
        List<PatientDTO> patientsDTO = new ArrayList<>();
        
        for(Patient p : patients){
            PatientDTO patientDTO = new PatientDTO(
                p.getFirstName(),
                p.getLastName(),
                p.getGender(),
                p.getBirthdate(),
                p.getAddress(),
                p.getPhoneNumber(),
                p.getEmail(),
                new ArrayList<>()
            );
            patientsDTO.add(patientDTO);
        }
        return patientsDTO;
    }
}
