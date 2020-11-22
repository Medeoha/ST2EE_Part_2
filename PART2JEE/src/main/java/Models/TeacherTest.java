/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Quentin
 */
@Stateless
public class TeacherTest {
   
    EntityManagerFactory emf;
    EntityManager em ;
    
    public List getallTeacher()
    {
       emf =  Persistence.createEntityManagerFactory("my_persistence_unit");
       em = emf.createEntityManager();
       em.getTransaction().begin();
       Query q = em.createNamedQuery("Teacher.findAll", Teacher.class);      
       List<Teacher> listOfTeachers = q.getResultList();
        
       em.close();
       emf.close();
              
       return listOfTeachers;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
