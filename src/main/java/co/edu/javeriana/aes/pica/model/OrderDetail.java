/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author sebastianpacheco
 */
public class OrderDetail {
    
    @JsonProperty("item_id")
    private int itemId;
    
    @JsonProperty("product_id")
    private int productId;
    
    @JsonProperty("spectacle_name")
    private String spectacleName;
    
    @JsonProperty("total_price")
    private int totalPrice;
    
    private int quantity;

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the spectacleName
     */
    public String getSpectacleName() {
        return spectacleName;
    }

    /**
     * @param spectacleName the spectacleName to set
     */
    public void setSpectacleName(String spectacleName) {
        this.spectacleName = spectacleName;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
