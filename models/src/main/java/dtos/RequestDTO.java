/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class RequestDTO {
    private String id;
    private LocalDateTime requestedAt;
    private String status;
    private PatientDTO patient;
    private List<ResultDTO> results;
    private List<TestDTO> tests;

    public RequestDTO() {
    }

    public RequestDTO(LocalDateTime requestedAt, String status, PatientDTO patient, List<ResultDTO> results, List<TestDTO> tests) {
        this.requestedAt = requestedAt;
        this.status = status;
        this.patient = patient;
        this.results = results;
        this.tests = tests;
    }

    public RequestDTO(String id, LocalDateTime requestedAt, String status, PatientDTO patient, List<ResultDTO> results, List<TestDTO> tests) {
        this.id = id;
        this.requestedAt = requestedAt;
        this.status = status;
        this.patient = patient;
        this.results = results;
        this.tests = tests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public List<ResultDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultDTO> results) {
        this.results = results;
    }

    public List<TestDTO> getTests() {
        return tests;
    }

    public void setTests(List<TestDTO> tests) {
        this.tests = tests;
    }
}
