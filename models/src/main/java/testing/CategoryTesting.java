/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import entities.Category;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class CategoryTesting {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Category c = new Category("Hematology", new ArrayList<>());
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
