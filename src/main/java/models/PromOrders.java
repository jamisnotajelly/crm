package models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="orders")
@XmlAccessorType(XmlAccessType.FIELD)
//TODO Define the usage of this field: whether to store it in DB or not. Could it be helpful?
public class PromOrders {
    @XmlAttribute
    private String date;

    @XmlElement(name="order")
    private List<PromOrder> promOrders = new ArrayList<>();

    public PromOrders() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PromOrder> getPromOrders() {
        return promOrders;
    }

    public void setPromOrders(List<PromOrder> promOrders) {
        this.promOrders = promOrders;
    }
}
