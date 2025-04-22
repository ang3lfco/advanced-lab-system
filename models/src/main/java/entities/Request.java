/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ang3lfco
 */
@Entity
@Table(name="requests")
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="requestedAt")
    private LocalDateTime requestedAt;
    
    @Column(name="status")
    private String status;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="patientId")
    private Patient patient;

    public Request() {
    }

    public Request(LocalDateTime requestedAt, String status, Patient patient) {
        this.requestedAt = requestedAt;
        this.status = status;
        this.patient = patient;
    }

    public Request(Long id, LocalDateTime requestedAt, String status, Patient patient) {
        this.id = id;
        this.requestedAt = requestedAt;
        this.status = status;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
