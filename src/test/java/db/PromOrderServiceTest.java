package db;

import models.PromItem;
import models.PromOrder;
import models.enums.State;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PromOrderServiceTest {
    private static final String MODIFIED_PREFIX = "modified-";
    private static PromOrderService promOrderService;
    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void init() {
        entityManagerFactory = JPAUtil.getEntityManagerFactory();
        promOrderService = new PromOrderService();
    }

    @After
    public void clear() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM " + PromItem.class.getSimpleName()).executeUpdate();
        entityManager.createQuery("DELETE FROM " + PromOrder.class.getSimpleName()).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void createTest() {
        PromOrder expectedOrder = createPromOrder();
        PromItem orderItem = createPromItem();
        expectedOrder.getPromItems().add(orderItem);
        orderItem.setPromOrder(expectedOrder);
        promOrderService.persist(expectedOrder);
        List<PromOrder> promOrders = promOrderService.findAll();
        Assert.assertEquals("Table should contain only one record", 1, promOrders.size());
        PromOrder orderFromDb = promOrders.get(0);
        Assert.assertEquals("Expected order should have only one item", 1, orderFromDb.getPromItems().size());
        assertThat(expectedOrder).isEqualToComparingFieldByFieldRecursively(orderFromDb);
    }

    @Test
    public void removeTest() {
        PromOrder orderToCreate = createPromOrder();
        PromItem orderItem = createPromItem();
        orderToCreate.getPromItems().add(orderItem);
        orderItem.setPromOrder(orderToCreate);
        promOrderService.persist(orderToCreate);
        List<PromOrder> promOrders = promOrderService.findAll();
        Assert.assertEquals("Table should contain only one record", 1, promOrders.size());
        PromOrder orderFromDb = promOrders.get(0);
        Assert.assertEquals("Expected order should have only one item", 1, orderFromDb.getPromItems().size());
        promOrderService.remove(orderFromDb.getId());
        promOrders = promOrderService.findAll();
        Assert.assertTrue("Table should have no records after deletion", promOrders.isEmpty());
    }

    @Test
    public void updateTest() {
        PromOrder orderToCreate = createPromOrder();
        PromItem orderItem = createPromItem();
        orderToCreate.getPromItems().add(orderItem);
        orderItem.setPromOrder(orderToCreate);
        promOrderService.persist(orderToCreate);
        List<PromOrder> promOrders = promOrderService.findAll();
        Assert.assertEquals("Table should contain only one record", 1, promOrders.size());
        PromOrder actualOrder = promOrders.get(0);
        Assert.assertEquals("Expected order should have only one item", 1, actualOrder.getPromItems().size());
        PromOrder updatedOrderWithItem = updateOrder(actualOrder);
        promOrderService.update(updatedOrderWithItem);
        PromOrder orderFromDb = promOrderService.find(updatedOrderWithItem.getId());
        assertThat(updatedOrderWithItem).isEqualToComparingFieldByFieldRecursively(orderFromDb);

    }

    private PromOrder createPromOrder() {
        PromOrder promOrder = new PromOrder();
        promOrder.setOrderId("74202475");
        promOrder.setState(State.NEW);
        promOrder.setDate("25.03.19 20:39");
        promOrder.setName("Кистрина Наталья");
        promOrder.setPhone("+380997228900");
        promOrder.setEmail("kistrina.natali@gmail.com");
        promOrder.setAddress("Одесса, Отделение 65");
        promOrder.setPaymentType("Наличными");
        promOrder.setDeliveryType("Транспортная компания \"Новая почта\"");
        promOrder.setPrice("720.00");
        promOrder.setDiscountedPriceUAH("720.00");
        promOrder.setSource("Портал");
        return promOrder;
    }

    private PromItem createPromItem() {
        PromItem promItem = new PromItem();
        promItem.setItemId("756859879");
        promItem.setName("Пеленка многоразовая для собак 40*60см");
        promItem.setQuantity("4.00");
        promItem.setCurrency("UAH");
        promItem.setImage("https://images.ua.prom.st/1279252469_w640_h640_pelenka-mnogorazovaya-dlya.jpg");
        promItem.setUrl("https://shinshilka.kiev.ua/p756859879-pelenka-mnogorazovaya-dlya.html");
        promItem.setPrice("180.00");
        promItem.setSku("26001");
        return promItem;
    }

    private PromOrder updateOrder(PromOrder promOrder) {
        promOrder.setOrderId(MODIFIED_PREFIX + promOrder.getOrderId());
        promOrder.setState(State.DRAFT);
        promOrder.setDate(MODIFIED_PREFIX + promOrder.getDate());
        promOrder.setName(MODIFIED_PREFIX + promOrder.getName());
        promOrder.setPhone(MODIFIED_PREFIX + promOrder.getPhone());
        promOrder.setEmail(MODIFIED_PREFIX + promOrder.getEmail());
        promOrder.setAddress(MODIFIED_PREFIX + promOrder.getAddress());
        promOrder.setPaymentType(MODIFIED_PREFIX + promOrder.getPaymentType());
        promOrder.setDeliveryType(MODIFIED_PREFIX + promOrder.getDeliveryType());
        promOrder.setPrice(MODIFIED_PREFIX + promOrder.getPrice());
        promOrder.setDiscountedPriceUAH(MODIFIED_PREFIX + promOrder.getDiscountedPriceUAH());
        promOrder.setSource(MODIFIED_PREFIX + promOrder.getSource());
        promOrder.getPromItems().forEach(this::updateItem);
        return promOrder;
    }

    private PromItem updateItem(PromItem promItem) {
        promItem.setItemId(MODIFIED_PREFIX + promItem.getItemId());
        promItem.setName(MODIFIED_PREFIX + promItem.getName());
        promItem.setQuantity("16.00");
        promItem.setCurrency("USD");
        promItem.setImage(MODIFIED_PREFIX + promItem.getImage());
        promItem.setUrl(MODIFIED_PREFIX + promItem.getUrl());
        promItem.setPrice("987.00");
        promItem.setSku(MODIFIED_PREFIX + promItem.getSku());
        return promItem;
    }
}
