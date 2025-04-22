/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entities.Patient;
import entities.Request;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class RequestTesting {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Request> rs = new ArrayList<>();
        Patient p = new Patient(
                "Emily",
                "Johnson",
                "F",
                LocalDate.of(1990, Month.JUNE, 5),
                "1600 Pennsylvania Avenue NW, Washington, DC",
                "2025550147",
                "emily.johnson@example.com",
                rs
        );
        Request r = new Request(LocalDateTime.now(), "In progress", p);
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }
}
