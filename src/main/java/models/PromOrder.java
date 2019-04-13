package models;

import binders.adapter.StateAdapter;
import models.enums.State;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
//TODO add abstract class?
public class PromOrder {

    @XmlAttribute(name = "id")
    private String orderId;

    @XmlAttribute
    @XmlJavaTypeAdapter(StateAdapter.class)
    private State state;

    @XmlElement
    private String date;

    @XmlElement
    private String name;

    @XmlElement
    private String company;

    @XmlElement
    private String phone;

    @XmlElement
    private String email;

    @XmlElement
    private String address;

    @XmlElement
    private String index;

    @XmlElement
    private String paymentType;

    @XmlElement
    private String deliveryType;

    @XmlElement(name = "deliverycost")
    private String deliveryCost;

    @XmlElement(name = "payercomment")
    private String payerComment;

    @XmlElement(name = "salescomment")
    private String salesComment;

    @XmlElements({
            @XmlElement(name = "price"),
            @XmlElement(name = "priceUAH")
    })
    private String price;

    @XmlElement
    private String discountedPriceUAH;

    @XmlElement
    private String source;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<PromItem> promItems = new ArrayList<>();

    private String exportDate;

    @XmlElement
    private String cancellationReason;

    @XmlElement
    private String cancellationReasonComment;

    public PromOrder() {
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

}
