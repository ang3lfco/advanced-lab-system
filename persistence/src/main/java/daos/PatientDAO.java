/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entities.Patient;
import exceptions.PersistenceException;
import interfaces.IDBConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ang3lfco
 */
public class PatientDAO {
    private IDBConnection conn;
    
    public PatientDAO(IDBConnection conn){
        this.conn = conn;
    }
    
    public void create(Patient patient){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(patient);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error creating patient", ex);
        }
        finally{
            em.close();
        }
    }
    
    public Patient read(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            return em.find(Patient.class, id);
        }
        catch(Exception ex){
            throw new PersistenceException("Error reading patient", ex);
        }
        finally{
            em.close();
        }
    }
    
    public void update(Patient patient){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(patient);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error updating patient", ex);
        }
        finally{
            em.close();
        }
    }
    
    public void delete(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            Patient patient = em.find(Patient.class, id);
            em.getTransaction().begin();
            if(patient != null){
                em.remove(patient);
            }
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error deleting patient", ex);
        }
        finally{
            em.close();
        }
    }
    
    public List<Patient> getPatients(){
        EntityManager em = conn.getEntityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
            Root<Patient> root = cq.from(Patient.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
        catch(Exception ex){
            throw new PersistenceException("Error getting patients", ex);
        }
        finally{
            em.close();
        }
    }
}
