/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entities.Category;
import entities.Parameter;
import entities.Request;
import entities.Test;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class TestTesting {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("N Gene", "Ct value", new ArrayList<>(), new ArrayList<>()));
        parameters.add(new Parameter("ORF1ab", "Ct value", new ArrayList<>(), new ArrayList<>()));
        parameters.add(new Parameter("S Gene", "Ct value", new ArrayList<>(), new ArrayList<>()));
        Category category = new Category("Virology", new ArrayList<>());
        List<Request> requests = new ArrayList<>();
        
        Test t = new Test(
                "COVID-19 PCR", 
                "Detects SARS-CoV-2 RNA using polymerase chain reaction",
                parameters,
                category,
                requests
        );
      
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
