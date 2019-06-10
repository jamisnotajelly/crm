package models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "prom_item")
@XmlAccessorType(XmlAccessType.FIELD)
//TODO add abstract class?
public class PromItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "item_id")
    @XmlAttribute(name = "id")
    private String itemId;

    @Column
    @XmlElement
    private String name;

    @Column
    @XmlElement
    private String quantity;

    @Column
    @XmlElement
    private String currency;

    @Column
    @XmlElement
    private String image;

    @Column
    @XmlElement
    private String url;

    @Column
    @XmlElement
    private String price;

    @Column
    @XmlElement
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prom_order_id")
    private PromOrder promOrder;

    @Column(name = "external_id")
    @XmlElement(name = "external_id")
    private String externalId;

    public PromItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public PromOrder getPromOrder() {
        return promOrder;
    }

    public void setPromOrder(PromOrder promOrder) {
        this.promOrder = promOrder;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

}
