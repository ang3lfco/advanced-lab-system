/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entities.Parameter;
import entities.Request;
import entities.Result;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class ResultTesting {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Long parameterId = 1L;
        Long requestId = 1L;
        Parameter parameter = em.find(Parameter.class, parameterId);
        Request request = em.find(Request.class, requestId);
        Result r = new Result("Detected", LocalDateTime.now(), parameter, request);
        
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
