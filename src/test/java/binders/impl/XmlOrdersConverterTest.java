package binders.impl;

import models.PromItem;
import models.PromOrder;
import models.PromOrders;
import models.enums.State;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class XmlOrdersConverterTest {
    private XmlOrdersConverter xmlOrdersConverter = new XmlOrdersConverter();

    @Test
    public void unmarshallOrdersWithDifferentElementNames() throws Exception {
        PromOrders actualOrders = xmlOrdersConverter.parse(getClass().getClassLoader().getResource("orders/ordersWithDifferentXmlElementNames.xml"));
        for (PromOrder promOrder:actualOrders.getPromOrders()) {
            assertThat(promOrder.getPrice()).isEqualTo("720.00");
        }
    }

    @Test
    public void unmarshallOneOrder() throws Exception {
        PromOrders expectedOrders = new PromOrders();
        expectedOrders.setDate("2019-03-25 21:06");

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

        PromItem promItem = new PromItem();
        promItem.setItemId("756859879");
        promItem.setName("Пеленка многоразовая для собак 40*60см");
        promItem.setQuantity("4.00");
        promItem.setCurrency("UAH");
        promItem.setImage("https://images.ua.prom.st/1279252469_w640_h640_pelenka-mnogorazovaya-dlya.jpg");
        promItem.setUrl("https://shinshilka.kiev.ua/p756859879-pelenka-mnogorazovaya-dlya.html");
        promItem.setPrice("180.00");
        promItem.setSku("26001");

        promOrder.getPromItems().add(promItem);
        expectedOrders.getPromOrders().add(promOrder);

        PromOrders actualOrders = xmlOrdersConverter.parse(getClass().getClassLoader().getResource("orders/oneOrder.xml"));

        assertThat(expectedOrders).isEqualToComparingFieldByFieldRecursively(actualOrders);
    }


    @Test
    public void unmarshallDeclinedOrder() throws Exception {
        PromOrders expectedOrders = new PromOrders();
        expectedOrders.setDate("2019-03-25 21:06");

        PromOrder promOrder = new PromOrder();
        promOrder.setOrderId("73966846");
        promOrder.setState(State.DECLINED);
        promOrder.setDate("22.03.19 11:47");
        promOrder.setName("Смолий Смолий Юлия");
        promOrder.setPhone("+380634104979");
        promOrder.setEmail("julikk.smeh@gmail.com");
        promOrder.setAddress("Полтава, Богдана Хмельницкого 21");
        promOrder.setPaymentType("Наложенный платеж");
        promOrder.setDeliveryType("Транспортная компания \"Новая почта\"");
        promOrder.setPayerComment("Мини чих мальчик кремовый) сумку ярко- розовую и комбезик зелёный розмерчик хс самый маленький");
        promOrder.setPrice("805.00");
        promOrder.setDiscountedPriceUAH("805.00");
        promOrder.setSource("Мобильное приложение каталога");
        promOrder.setCancellationReason("Нет в наличии");
        promOrder.setCancellationReasonComment("Добрый день! К сожалению к 12802 нет в наличии, будем с сайте убирать, предлагаем посетить наш главный сайт https://shinshilka.ua. Тут более актуальный ассортимент и цены товаров. Спасибо!");

        PromItem firstExpectedItem = new PromItem();
        firstExpectedItem.setItemId("679307836");
        firstExpectedItem.setName("Сумка-переноска Candy Rose для кошек и собак ( 40,5см * 22см * 28см)");
        firstExpectedItem.setQuantity("1.00");
        firstExpectedItem.setCurrency("UAH");
        firstExpectedItem.setImage("https://images.ua.prom.st/1111528652_w640_h640_sumka-perenoska-candy-rose.jpg");
        firstExpectedItem.setUrl("https://shinshilka.kiev.ua/p679307836-sumka-perenoska-candy.html");
        firstExpectedItem.setPrice("525.00");
        firstExpectedItem.setSku("12802");

        PromItem secondExpectedItem = new PromItem();
        secondExpectedItem.setItemId("586483929");
        secondExpectedItem.setName("Толстовка Pet Fashion \"Тиффани\" 23-26см (XXS) для собак");
        secondExpectedItem.setQuantity("1.00");
        secondExpectedItem.setCurrency("UAH");
        secondExpectedItem.setImage("https://images.ua.prom.st/913093540_w640_h640_tolstovka-pet-fashion.jpg");
        secondExpectedItem.setUrl("https://shinshilka.kiev.ua/p586483929-tolstovka-pet-fashion.html");
        secondExpectedItem.setPrice("280.00");
        secondExpectedItem.setSku("19636");

        promOrder.getPromItems().add(firstExpectedItem);
        promOrder.getPromItems().add(secondExpectedItem);

        expectedOrders.getPromOrders().add(promOrder);

        PromOrders actualOrders = xmlOrdersConverter.parse(getClass().getClassLoader().getResource("orders/orderWithDeclinedState.xml"));

        assertThat(expectedOrders).isEqualToComparingFieldByFieldRecursively(actualOrders);
    }
}