/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entities.Patient;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class PatientTesting {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient p = new Patient(
                "Laura", 
                "Smith", 
                "F", 
                LocalDate.of(1995, Month.AUGUST, 21), 
                "742 Evergreen Terrace, Springfield, IL",
                "3125550198",
                "laura.smith@example.com",
                new ArrayList<>()
        );
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
