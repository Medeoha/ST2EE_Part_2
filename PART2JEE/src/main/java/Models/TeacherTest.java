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
   
    @PersistenceContext
    EntityManager em;
    
    public List getallTeacher()
    {
  
       Query q = em.createNamedQuery("Teacher.findAll", Teacher.class);
       return q.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
