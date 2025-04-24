/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entities.Parameter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class ParameterTesting {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Parameter p1 = new Parameter("White Blood Cells", "10^9/L", new ArrayList<>(), new ArrayList<>());
        Parameter p2 = new Parameter("Red Blood Cells", "10^12/L", new ArrayList<>(), new ArrayList<>());
        Parameter p3 = new Parameter("Hemoglobin", "g/dL", new ArrayList<>(), new ArrayList<>());
        Parameter p4 = new Parameter("Hematocrit", "%", new ArrayList<>(), new ArrayList<>());
        Parameter p5 = new Parameter("Platelets", "10^9/L", new ArrayList<>(), new ArrayList<>());

        
        List<Parameter> ps = List.of(p1, p2, p3, p4, p5);
        for(Parameter p : ps){
            em.persist(p);
        }
        
        em.getTransaction().commit();
        em.clear();
        emf.close();
    }
}
