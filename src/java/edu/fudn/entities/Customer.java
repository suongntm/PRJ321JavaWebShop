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
 * Customers generated by hbm2java
 */
@Entity
@Table(name="Customers"
    ,schema="dbo"
    ,catalog="FUD"
)
public class Customer  implements java.io.Serializable {


     private int customerId;
     private String name;
     private boolean gender;
     private Date dayOfBirth;
     private String email;
     private String phone;
     private String status;
     private String password;
     private Date registeredDate;
     private Set<Cart> carts = new HashSet<Cart>(0);

    public Customer() {
    }

	
    public Customer(int customerId, String name, boolean gender, String password, Date registeredDate) {
        this.customerId = customerId;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.registeredDate = registeredDate;
    }
    public Customer(int customerId, String name, boolean gender, Date dayOfBirth, String email, String phone, String status, String password, Date registeredDate, Set<Cart> carts) {
       this.customerId = customerId;
       this.name = name;
       this.gender = gender;
       this.dayOfBirth = dayOfBirth;
       this.email = email;
       this.phone = phone;
       this.status = status;
       this.password = password;
       this.registeredDate = registeredDate;
       this.carts = carts;
    }
   
     @Id 

    
    @Column(name="CustomerId", unique=true, nullable=false)
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    
    @Column(name="Name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="Gender", nullable=false)
    public boolean isGender() {
        return this.gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DayOfBirth", length=10)
    public Date getDayOfBirth() {
        return this.dayOfBirth;
    }
    
    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    
    @Column(name="Email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="Phone", length=30)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="Status", length=20)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="Password", nullable=false, length=30)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RegisteredDate", nullable=false, length=10)
    public Date getRegisteredDate() {
        return this.registeredDate;
    }
    
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="customers")
    public Set<Cart> getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }


}


