package db;

import models.PromOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class PromOrderService {
    private static final Logger logger = LoggerFactory.getLogger(PromOrderService.class);

    public void persist(PromOrder promOrder) {
        logger.info("Starting to persist order {}", promOrder);
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(promOrder);
        entityManager.getTransaction().commit();
        logger.info("Finishing to persist order {}", promOrder);
        entityManager.close();
    }

    public PromOrder find(Long id) {
        logger.info("Starting to search for order with id {}", id);
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        PromOrder promOrder = entityManager.find(PromOrder.class, id);
        entityManager.close();
        logger.info("Order {} was found", promOrder);
        return promOrder;
    }

    public void remove(Long id) {
        logger.info("Starting to remove order with id {}", id);
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        PromOrder promOrder = entityManager.find(PromOrder.class, id);
        entityManager.remove(promOrder);
        entityManager.getTransaction().commit();
        logger.info("Order with id {} was removed", id);
        entityManager.close();
    }

    @SuppressWarnings("unchecked")
    public List<PromOrder> findAll() {
        logger.info("Starting to query orders");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<PromOrder> promOrders = entityManager.createQuery("Select o from " + PromOrder.class.getSimpleName() + " o LEFT JOIN FETCH o.promItems").getResultList();
        entityManager.close();
        logger.info("{} orders were found", promOrders.size());
        return promOrders;
    }

    public void update(PromOrder promOrder) {
        logger.info("Starting to update order {}", promOrder);
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(promOrder);
        entityManager.getTransaction().commit();
        logger.info("Finishing to update order {}", promOrder);
        entityManager.close();
    }
}
