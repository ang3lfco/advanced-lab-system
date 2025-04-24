/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entities.Result;
import exceptions.PersistenceException;
import interfaces.IDBConnection;
import interfaces.IResultDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ang3lfco
 */
public class ResultDAO implements IResultDAO{
    private IDBConnection conn;
    
    public ResultDAO(IDBConnection conn){
        this.conn = conn;
    }
    
    @Override
    public void create(Result result){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(result);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error creating result", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public Result read(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            return em.find(Result.class, id);
        }
        catch(Exception ex){
            throw new PersistenceException("Error reading result", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void update(Result result){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(result);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error updating result", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void delete(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            Result result = em.find(Result.class, id);
            em.getTransaction().begin();
            if(result != null){
                em.remove(result);
            }
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error deleting result", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public List<Result> getResults(){
        EntityManager em = conn.getEntityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Result> cq = cb.createQuery(Result.class);
            Root<Result> root = cq.from(Result.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
        catch(Exception ex){
            throw new PersistenceException("Error getting results", ex);
        }
        finally{
            em.close();
        }
    }
}
