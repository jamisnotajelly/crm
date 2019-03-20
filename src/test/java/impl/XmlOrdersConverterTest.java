package impl;

import model.Item;
import model.Order;
import model.Orders;
import model.State;
import org.junit.Test;

public class XmlOrdersConverterTest {
    private XmlOrdersConverter xmlOrdersConverter = new XmlOrdersConverter();

    @Test
    public void parse() throws Exception {
        Orders orders = xmlOrdersConverter.parse(getClass().getClassLoader().getResource("orders.xml").getPath());
        System.out.println();
    }

    @Test
    public void parseXmlWithManuallyGeneratedOrders() throws Exception {
        Orders orders = new Orders();
        orders.setDate("15.07.18 09:45");
        Order order = buildExpectedOrder();
        order.getItems().add(buildExpectedItem());

        orders.getOrders().add(buildExpectedOrder());
    }

    public Order buildExpectedOrder() {
        Order order = new Order();
        order.setOrderId("102-eg3-th2-99y");
        order.setState(State.ACCEPTED);
        order.setDate("15.07.19 19:22");
        order.setName("Владислав Язов");
        order.setCompany("Ukrsibbank");
        order.setPhone("+3809966600066");
        order.setEmail("somemail@some.com");
        order.setAddress("Крученый, ул. Мостыгинская, 99");
        order.setIndex("89000");
        order.setPaymentType("Наличными");
        order.setDeliveryType("Новая почта");
        order.setPayerComment("Заверните красиво");
        order.setSalesComment("Посмотрим...");
        order.setPrice("650.50");
        return order;
    }

    public Item buildExpectedItem() {
        Item item = new Item();
        item.setItemId("98-ghel-eeef-877");
        item.setName("потопилка для кота");
        item.setQuantity("1");
        item.setPrice("650.50");
        item.setCurrency("UAH");
        item.setImage("some image url");
        item.setUrl("another one image url");
        return item;
    }

}