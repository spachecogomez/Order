/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.entities;

import co.edu.javeriana.aes.pica.entities.OrderEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;

/**
 *
 * @author sebastianpacheco
 */
@Embeddable
public class ItemKey implements Serializable{
    
    @Column(name = "ITEM_ID")
    private Integer itemId;
    
//    @Column(name = "ORDER_ID")
//    @ManyToMany(mappedBy = "items",targetEntity = OrderEntity.class)
//    private Integer orderId;

    /**
     * @return the itemId
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

//    /**
//     * @return the orderId
//     */
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//    /**
//     * @param orderId the orderId to set
//     */
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
    
}
