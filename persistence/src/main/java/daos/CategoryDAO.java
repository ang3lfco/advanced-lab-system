/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entities.Category;
import exceptions.PersistenceException;
import interfaces.ICategoryDAO;
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
public class CategoryDAO implements ICategoryDAO{
    private IDBConnection conn;
    
    public CategoryDAO(IDBConnection conn){
        this.conn = conn;
    }
    
    @Override
    public void create(Category category){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error creating category", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public Category read(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            return em.find(Category.class, id);
        }
        catch(Exception ex){
            throw new PersistenceException("Error reading category", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void update(Category category){
        EntityManager em = conn.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error updating category", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void delete(Long id){
        EntityManager em = conn.getEntityManager();
        try{
            Category category = em.find(Category.class, id);
            em.getTransaction().begin();
            if(category != null){
                em.remove(category);
            }
            em.getTransaction().commit();
        }
        catch(Exception ex){
            em.getTransaction().rollback();
            throw new PersistenceException("Error deleting category", ex);
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public List<Category> getCategories(){
        EntityManager em = conn.getEntityManager();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> root = cq.from(Category.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
        catch(Exception ex){
            throw new PersistenceException("Error getting categories", ex);
        }
        finally{
            em.close();
        }
    }
}
