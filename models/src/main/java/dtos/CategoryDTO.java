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
public class CategoryDTO {
    private String id;
    private String name;
    private List<TestDTO> tests;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, List<TestDTO> tests) {
        this.name = name;
        this.tests = tests;
    }

    public CategoryDTO(String id, String name, List<TestDTO> tests) {
        this.id = id;
        this.name = name;
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

    public List<TestDTO> getTests() {
        return tests;
    }

    public void setTests(List<TestDTO> tests) {
        this.tests = tests;
    }
}
