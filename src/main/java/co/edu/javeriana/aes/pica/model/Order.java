/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sebastianpacheco
 */
public class Order {
    
    @JsonProperty("order_id")
    private int orderId;
    
    @JsonProperty("order_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date orderDate;
    
    @JsonProperty("order_price")
    private BigDecimal orderPrice;
    
    @JsonProperty("order_status")
    private OrderStatus status;
    
    @JsonProperty("order_comments")
    private String orderComments;
    
    @JsonProperty("customer_details")
    private CustomerDetail customerDetails;
    
    @JsonProperty("order_details")
    private List<OrderDetail> orderDetails;
    
    public Order(){
        
    }
    
    public Order(int orderId, Date orderDate, BigDecimal orderPrice,String status,
             String orderComments ,CustomerDetail customerDetails,List<OrderDetail> orderDetails){
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setStatusName(status);
        this.status = orderStatus;
        this.orderComments = orderComments;
        this.customerDetails = customerDetails;
        this.orderDetails = orderDetails;
        this.customerDetails = customerDetails;
        this.orderDetails = orderDetails;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the orderPrice
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * @param orderPrice the orderPrice to set
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * @return the orderComments
     */
    public String getOrderComments() {
        return orderComments;
    }

    /**
     * @param orderComments the orderComments to set
     */
    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    /**
     * @return the customerDetails
     */
    public CustomerDetail getCustomerDetails() {
        return customerDetails;
    }

    /**
     * @param customerDetails the customerDetails to set
     */
    public void setCustomerDetails(CustomerDetail customerDetails) {
        this.customerDetails = customerDetails;
    }

    /**
     * @return the orderDetails
     */
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails the orderDetails to set
     */
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    
    
}
