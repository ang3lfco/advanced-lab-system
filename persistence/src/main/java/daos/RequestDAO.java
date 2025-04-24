/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entities.Request;
import exceptions.PersistenceException;
import interfaces.IDBConnection;
import interfaces.IRequestDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ang3lfco
 */
public class RequestDAO implements IRequestDAO{
    private IDBConnection conn;
    
    public RequestDAO(IDBConnection conn){
        this.conn = conn;
    }
    
    @Override
    public void create(Request request){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(request);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error creating request", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public Request read(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            return em.find(Request.class, id);
        }
        catch(Exception ex){
            throw new PersistenceException("Error reading request", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void update(Request request){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(request);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error updating request", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void delete(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            Request request = em.find(Request.class, id);
            em.getTransaction().begin();
            if(request != null){
                em.remove(request);
            }
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error deleting request", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public List<Request> getRequests(){
        EntityManager em = conn.getEntityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Request> cq = cb.createQuery(Request.class);
            Root<Request> root = cq.from(Request.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
        catch(Exception ex){
            throw new PersistenceException("Error getting requests", ex);
        }
        finally{
            em.close();
        }
    }
}
