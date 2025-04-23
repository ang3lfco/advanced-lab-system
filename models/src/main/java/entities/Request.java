/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @OneToMany(mappedBy="request")
    private List<Result> results;
    
    @ManyToMany
    @JoinTable(name="request_test", 
            joinColumns = @JoinColumn(name="requestId"), 
            inverseJoinColumns = @JoinColumn(name="testId"))
    private List<Test> tests;

    public Request() {
    }

    public Request(LocalDateTime requestedAt, String status, Patient patient, List<Result> results, List<Test> tests) {
        this.requestedAt = requestedAt;
        this.status = status;
        this.patient = patient;
        this.results = results;
        this.tests = tests;
    }

    public Request(Long id, LocalDateTime requestedAt, String status, Patient patient, List<Result> results, List<Test> tests) {
        this.id = id;
        this.requestedAt = requestedAt;
        this.status = status;
        this.patient = patient;
        this.results = results;
        this.tests = tests;
    }
}
