/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author sebastianpacheco
 */
@Entity
@Table(name = "ORDERS")
public class OrderEntity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    private CustomerEntity custId;
    
    
    @Column(name = "PRICE")
    private Integer price;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_generator")
    @SequenceGenerator(sequenceName = "ORDERS_SQ", allocationSize = 1, name = "orders_generator")
    @Column(name = "ORD_ID")
    private Integer orderID;
    
    
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    
    
    @Column(name = "STATUS")
    private String orderStatus;
    
    @Column(name = "COMMENTS")
    private String comments;
    
    
    @OneToMany(cascade = CascadeType.ALL , targetEntity = ItemEntity.class, mappedBy = "orderEntity")
    private List<ItemEntity> itemEntity;

    /**
     * @return the orderID
     */
    public Integer getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
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
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    public OrderEntity() {
    }

    public CustomerEntity getCustId() {
        return custId;
    }

    public void setCustId(CustomerEntity custId) {
        this.custId = custId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<ItemEntity> getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(List<ItemEntity> itemEntity) {
        this.itemEntity = itemEntity;
    }

    
}
