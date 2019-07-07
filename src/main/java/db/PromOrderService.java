package db;

import models.PromOrder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class PromOrderService {

    public void persist(PromOrder promOrder) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(promOrder);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public PromOrder find(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        PromOrder promOrder = entityManager.find(PromOrder.class, id);
        entityManager.close();
        return promOrder;
    }

    public void remove(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        PromOrder promOrder = entityManager.find(PromOrder.class, id);
        entityManager.remove(promOrder);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @SuppressWarnings("unchecked")
    public List<PromOrder> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<PromOrder> promOrders = entityManager.createQuery("Select o from " + PromOrder.class.getSimpleName() + " o LEFT JOIN FETCH o.promItems").getResultList();
        entityManager.close();
        return promOrders;
    }

    public void update(PromOrder promOrder) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(promOrder);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
