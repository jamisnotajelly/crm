package model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {
    @XmlAttribute
    private String date;

    @XmlElement(name="order")
    private List<Order> orders = new ArrayList<>();

    public Orders() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
