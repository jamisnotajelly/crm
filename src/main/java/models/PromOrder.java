package models;

import binders.adapter.StateAdapter;
import models.enums.State;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
//TODO add abstract class?
@Entity
@Table(name = "prom_order")
public class PromOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_id")
    @XmlAttribute(name = "id")
    private String orderId;

    @Column
    @Enumerated(EnumType.STRING)
    @XmlAttribute
    @XmlJavaTypeAdapter(StateAdapter.class)
    private State state;

    @Column
    @XmlElement
    private String date;

    @Column
    @XmlElement
    private String name;

    @Column
    @XmlElement
    private String company;

    @Column
    @XmlElement
    private String phone;

    @Column
    @XmlElement
    private String email;

    @Column
    @XmlElement
    private String address;

    @Column
    @XmlElement
    private String index;

    @Column(name = "payment_type")
    @XmlElement
    private String paymentType;

    @Column(name = "delivery_type")
    @XmlElement
    private String deliveryType;

    @Column(name = "delivery_cost")
    @XmlElement(name = "deliverycost")
    private String deliveryCost;

    @Column(name = "payer_comment")
    @XmlElement(name = "payercomment")
    private String payerComment;

    @Column(name = "sales_comment")
    @XmlElement(name = "salescomment")
    private String salesComment;

    @Column
    @XmlElements({
            @XmlElement(name = "price"),
            @XmlElement(name = "priceUAH")
    })
    private String price;

    @Column(name = "discounted_price_uah")
    @XmlElement
    private String discountedPriceUAH;

    @Column
    @XmlElement
    private String source;

    @OneToMany(mappedBy = "promOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<PromItem> promItems = new ArrayList<>();

    @Column(name = "export_date")
    private String exportDate;

    @Column(name = "cancellation_reason")
    @XmlElement
    private String cancellationReason;

    @Column(name = "cancellation_reason_comment")
    @XmlElement
    private String cancellationReasonComment;

    public PromOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getPayerComment() {
        return payerComment;
    }

    public void setPayerComment(String payerComment) {
        this.payerComment = payerComment;
    }

    public String getSalesComment() {
        return salesComment;
    }

    public void setSalesComment(String salesComment) {
        this.salesComment = salesComment;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<PromItem> getPromItems() {
        return promItems;
    }

    public void setPromItems(List<PromItem> promItems) {
        this.promItems = promItems;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public String getDiscountedPriceUAH() {
        return discountedPriceUAH;
    }

    public void setDiscountedPriceUAH(String discountedPriceUAH) {
        this.discountedPriceUAH = discountedPriceUAH;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getCancellationReasonComment() {
        return cancellationReasonComment;
    }

    public void setCancellationReasonComment(String cancellationReasonComment) {
        this.cancellationReasonComment = cancellationReasonComment;
    }

    @Override
    public String toString() {
        return "PromOrder{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", state=" + state +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", index='" + index + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", deliveryCost='" + deliveryCost + '\'' +
                ", payerComment='" + payerComment + '\'' +
                ", salesComment='" + salesComment + '\'' +
                ", price='" + price + '\'' +
                ", discountedPriceUAH='" + discountedPriceUAH + '\'' +
                ", source='" + source + '\'' +
                ", promItems=" + promItems +
                ", exportDate='" + exportDate + '\'' +
                ", cancellationReason='" + cancellationReason + '\'' +
                ", cancellationReasonComment='" + cancellationReasonComment + '\'' +
                '}';
    }
}
