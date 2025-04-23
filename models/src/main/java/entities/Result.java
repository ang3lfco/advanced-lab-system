/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name="results")
public class Result implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="value")
    private String value;
    
    @Column(name="valuedAt")
    private LocalDateTime valuedAt;
    
    @ManyToOne
    @JoinColumn(name="parameterId")
    private Parameter parameter;
    
    @ManyToOne
    @JoinColumn(name="requestId")
    private Request request;

    public Result() {
    }

    public Result(String value, LocalDateTime valuedAt, Parameter parameter, Request request) {
        this.value = value;
        this.valuedAt = valuedAt;
        this.parameter = parameter;
        this.request = request;
    }

    public Result(Long id, String value, LocalDateTime valuedAt, Parameter parameter, Request request) {
        this.id = id;
        this.value = value;
        this.valuedAt = valuedAt;
        this.parameter = parameter;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getValuedAt() {
        return valuedAt;
    }

    public void setValuedAt(LocalDateTime valuedAt) {
        this.valuedAt = valuedAt;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
