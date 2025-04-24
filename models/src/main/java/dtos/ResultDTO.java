/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;

/**
 *
 * @author ang3lfco
 */
public class ResultDTO {
    private String id;
    private String value;
    private LocalDateTime valuedAt;
    private ParameterDTO parameter;
    private RequestDTO request;

    public ResultDTO() {
    }

    public ResultDTO(String value, LocalDateTime valuedAt, ParameterDTO parameter, RequestDTO request) {
        this.value = value;
        this.valuedAt = valuedAt;
        this.parameter = parameter;
        this.request = request;
    }

    public ResultDTO(String id, String value, LocalDateTime valuedAt, ParameterDTO parameter, RequestDTO request) {
        this.id = id;
        this.value = value;
        this.valuedAt = valuedAt;
        this.parameter = parameter;
        this.request = request;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ParameterDTO getParameter() {
        return parameter;
    }

    public void setParameter(ParameterDTO parameter) {
        this.parameter = parameter;
    }

    public RequestDTO getRequest() {
        return request;
    }

    public void setRequest(RequestDTO request) {
        this.request = request;
    }
}
