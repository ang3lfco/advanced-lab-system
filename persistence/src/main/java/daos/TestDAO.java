/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entities.Test;
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
public class TestDAO {
    private IDBConnection conn;
    
    public TestDAO(IDBConnection conn){
        this.conn = conn;
    }
    
    public void create(Test test){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(test);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("", ex);
        }
        finally{
            em.close();
        }
    }
    
    public Test read(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            return em.find(Test.class, id);
        }
        catch(Exception ex){
            throw new PersistenceException("", ex);
        }
        finally{
            em.close();
        }
    }
    
    public void update(Test test){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(test);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("", ex);
        }
        finally{
            em.close();
        }
    }
    
    public void delete(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            Test test = em.find(Test.class, id);
            em.getTransaction().begin();
            if(test != null){
                em.remove(test);
            }
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("", ex);
        }
        finally{
            em.close();
        }
    }
    
    public List<Test> getTests(){
        EntityManager em = conn.getEntityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Test> cq = cb.createQuery(Test.class);
            Root<Test> root = cq.from(Test.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
        catch(Exception ex){
            throw new PersistenceException("Error getting tests", ex);
        }
        finally{
            em.close();
        }
    }
}
