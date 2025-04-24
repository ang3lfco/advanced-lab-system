/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class ParameterDTO {
    private String id;
    private String name;
    private String unit;
    private List<ResultDTO> results;
    private List<TestDTO> tests;

    public ParameterDTO() {
    }

    public ParameterDTO(String name, String unit, List<ResultDTO> results, List<TestDTO> tests) {
        this.name = name;
        this.unit = unit;
        this.results = results;
        this.tests = tests;
    }

    public ParameterDTO(String id, String name, String unit, List<ResultDTO> results, List<TestDTO> tests) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.results = results;
        this.tests = tests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
