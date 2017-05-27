/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.model;

import java.util.List;

/**
 *
 * @author sebastianpacheco
 */
public class OrderList {
    
    private long size;
    
    private List<Order> details;

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return the details
     */
    public List<Order> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(List<Order> details) {
        this.details = details;
    }
    
    
    
}
