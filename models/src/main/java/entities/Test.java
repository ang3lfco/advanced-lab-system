/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author ang3lfco
 */
@Entity
@Table(name="tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="test_parameter", 
            joinColumns = @JoinColumn(name="testId"), 
            inverseJoinColumns = @JoinColumn(name="parameterId"))
    private List<Parameter> parameters;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="categoryId")
    private Category category;
    
    @ManyToMany(mappedBy="tests")
    private List<Request> requests;

    public Test() {
    }

    public Test(String name, String description, List<Parameter> parameters, Category category, List<Request> requests) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.category = category;
        this.requests = requests;
    }

    public Test(Long id, String name, String description, List<Parameter> parameters, Category category, List<Request> requests) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.category = category;
        this.requests = requests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
