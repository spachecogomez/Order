/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.aes.pica.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastianpacheco
 */
@Entity
@Table(name = "ITEMS", catalog = "", schema = "TBVENTAS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ITEM_ID"}),
    @UniqueConstraint(columnNames = {"ORD_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemEntity.findAll", query = "SELECT i FROM ItemEntity i"),
    @NamedQuery(name = "ItemEntity.findByItemId", query = "SELECT i FROM ItemEntity i WHERE i.itemEntityPK.itemId = :itemId"),
    @NamedQuery(name = "ItemEntity.findByProdId", query = "SELECT i FROM ItemEntity i WHERE i.prodId = :prodId"),
    @NamedQuery(name = "ItemEntity.findByProductName", query = "SELECT i FROM ItemEntity i WHERE i.productName = :productName"),
    @NamedQuery(name = "ItemEntity.findByPartNum", query = "SELECT i FROM ItemEntity i WHERE i.partNum = :partNum"),
    @NamedQuery(name = "ItemEntity.findByPrice", query = "SELECT i FROM ItemEntity i WHERE i.price = :price"),
    @NamedQuery(name = "ItemEntity.findByQuantity", query = "SELECT i FROM ItemEntity i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "ItemEntity.findByOrdId", query = "SELECT i FROM ItemEntity i WHERE i.itemEntityPK.ordId = :ordId")})
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemEntityPK itemEntityPK;
    @Column(name = "PROD_ID")
    private BigInteger prodId;
    @Size(max = 50)
    @Column(name = "PRODUCT_NAME", length = 50)
    private String productName;
    @Size(max = 20)
    @Column(name = "PART_NUM", length = 20)
    private String partNum;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "QUANTITY")
    private Integer quantity;
//    @MapsId
    @JoinColumn(name = "ORD_ID", referencedColumnName = "ORD_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(targetEntity = OrderEntity.class)
    private OrderEntity orderEntity;

    public ItemEntity() {
    }

    public ItemEntity(ItemEntityPK itemEntityPK) {
        this.itemEntityPK = itemEntityPK;
    }

    public ItemEntity(String itemId, Integer ordId) {
        this.itemEntityPK = new ItemEntityPK(itemId, ordId);
    }

    public ItemEntityPK getItemEntityPK() {
        return itemEntityPK;
    }

    public void setItemEntityPK(ItemEntityPK itemEntityPK) {
        this.itemEntityPK = itemEntityPK;
    }

    public BigInteger getProdId() {
        return prodId;
    }

    public void setProdId(BigInteger prodId) {
        this.prodId = prodId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemEntityPK != null ? itemEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntity)) {
            return false;
        }
        ItemEntity other = (ItemEntity) object;
        if ((this.itemEntityPK == null && other.itemEntityPK != null) || (this.itemEntityPK != null && !this.itemEntityPK.equals(other.itemEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.aes.pica.entities.ItemEntity[ itemEntityPK=" + itemEntityPK + " ]";
    }
    
}
