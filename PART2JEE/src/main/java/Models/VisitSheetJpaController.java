/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Quentin
 */
public class VisitSheetJpaController implements Serializable {

    public VisitSheetJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VisitSheet visitSheet) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(visitSheet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VisitSheet visitSheet) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            visitSheet = em.merge(visitSheet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = visitSheet.getId();
                if (findVisitSheet(id) == null) {
                    throw new NonexistentEntityException("The visitSheet with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VisitSheet visitSheet;
            try {
                visitSheet = em.getReference(VisitSheet.class, id);
                visitSheet.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visitSheet with id " + id + " no longer exists.", enfe);
            }
            em.remove(visitSheet);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VisitSheet> findVisitSheetEntities() {
        return findVisitSheetEntities(true, -1, -1);
    }

    public List<VisitSheet> findVisitSheetEntities(int maxResults, int firstResult) {
        return findVisitSheetEntities(false, maxResults, firstResult);
    }

    private List<VisitSheet> findVisitSheetEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VisitSheet.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public VisitSheet findVisitSheet(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VisitSheet.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisitSheetCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VisitSheet> rt = cq.from(VisitSheet.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
