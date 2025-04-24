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
public class TestDTO {
    private String id;
    private String name;
    private String description;
    private List<ParameterDTO> parameters;
    private CategoryDTO category;
    private List<RequestDTO> requests;

    public TestDTO() {
    }

    public TestDTO(String name, String description, List<ParameterDTO> parameters, CategoryDTO category, List<RequestDTO> requests) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.category = category;
        this.requests = requests;
    }

    public TestDTO(String id, String name, String description, List<ParameterDTO> parameters, CategoryDTO category, List<RequestDTO> requests) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.category = category;
        this.requests = requests;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ParameterDTO> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDTO> parameters) {
        this.parameters = parameters;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<RequestDTO> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestDTO> requests) {
        this.requests = requests;
    }
}
