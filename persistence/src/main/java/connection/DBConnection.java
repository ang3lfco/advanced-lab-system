/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import interfaces.IDBConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class DBConnection implements IDBConnection{
    private EntityManagerFactory emf;
    
    public DBConnection(){
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_models_jar_1.0-SNAPSHOTPU");
    }
    
    @Override
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    @Override
    public void close(){
        emf.close();
    }
}
