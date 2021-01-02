package edu.fudn.entities;
// Generated Jan 2, 2021 10:52:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Carts generated by hbm2java
 */
@Entity
@Table(name="Carts"
    ,schema="dbo"
    ,catalog="FUD"
)
public class Cart  implements java.io.Serializable {


     private int cartId;
     private Integer customerId;
     private Date createdDate;
     private String status;
     private Set<CartDetail> cartDetailIds = new HashSet<CartDetail>(0);

    public Cart() {
    }

	
    public Cart(int cartId) {
        this.cartId = cartId;
    }
    public Cart(int cartId, Integer customerId, Date createdDate, String status, Set<CartDetail> cartDetailIds) {
       this.cartId = cartId;
       this.customerId = customerId;
       this.createdDate = createdDate;
       this.status = status;
       this.cartDetailIds = cartDetailIds;
    }
   
     @Id 

    
    @Column(name="CartId", unique=true, nullable=false)
    public int getCartId() {
        return this.cartId;
    }
    
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    
    @Column(name="CustomerId")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CreatedDate", length=10)
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    @Column(name="Status")
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="carts")
    public Set<CartDetail> getCartDetailIds() {
        return this.cartDetailIds;
    }
    
    public void setCartDetailIds(Set<CartDetail> cartDetailIds) {
        this.cartDetailIds = cartDetailIds;
    }




}

