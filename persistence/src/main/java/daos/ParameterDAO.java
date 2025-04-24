/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import exceptions.PersistenceException;
import interfaces.IDBConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ang3lfco
 */
public class ParameterDAO {
    private IDBConnection conn;
    
    public ParameterDAO(IDBConnection conn){
        this.conn = conn;
    }
    
    public void create(Parameter parameter){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(parameter);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error creating parameter", ex);
        }
        finally{
            em.close();
        }
    }
    
    public Parameter read(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            return em.find(Parameter.class, id);
        }
        catch(Exception ex){
            throw new PersistenceException("Error reading parameter", ex);
        }
        finally{
            em.close();
        }
    }
    
    public void update(Parameter parameter){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(parameter);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error updating parameter", ex);
        }
        finally{
            em.close();
        }
    }
    
    public void delete(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            Parameter parameter = em.find(Parameter.class, id);
            em.getTransaction().begin();
            if(parameter != null){
                em.remove(parameter);
            }
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error deleting parameter", ex);
        }
        finally{
            em.close();
        }
    }
    
    public List<Parameter> getParameters(){
        EntityManager em = conn.getEntityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Parameter> cq = cb.createQuery(Parameter.class);
            Root<Parameter> root = cq.from(Parameter.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
        catch(Exception ex){
            throw new PersistenceException("Error getting parameters", ex);
        }
        finally{
            em.close();
        }
    }
}
