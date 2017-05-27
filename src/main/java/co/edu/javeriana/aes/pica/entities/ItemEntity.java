/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sebastianpacheco
 */
@Entity
@Table(name = "ITEMS")
public class ItemEntity {
    
    @EmbeddedId
    private ItemKey itemKey;
    
    @Column(name = "PROD_ID")
    private Integer prodId;
    
    @Column(name = "PRODUCT_NAME")
    private String productName;
    
    @Column(name = "PART_NUM")
    private String partNum;
    
    @Column(name = "PRICE")
    private BigDecimal price;
    
    @Column(name = "QUANTITY")
    private Integer quantity;
    
//    @ManyToOne
//    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

    /**
     * @return the itemKey
     */
    public ItemKey getItemKey() {
        return itemKey;
    }

    /**
     * @param itemKey the itemKey to set
     */
    public void setItemKey(ItemKey itemKey) {
        this.itemKey = itemKey;
    }

    /**
     * @return the prodId
     */
    public Integer getProdId() {
        return prodId;
    }

    /**
     * @param prodId the prodId to set
     */
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the partNum
     */
    public String getPartNum() {
        return partNum;
    }

    /**
     * @param partNum the partNum to set
     */
    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
