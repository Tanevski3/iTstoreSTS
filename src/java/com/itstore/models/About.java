package com.itstore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tanevski
 */
@Entity
@Table(name = "about")
public class About {
    
    private Integer id;
    private String address;
    private String email;
    private String phone;
    private String fax;
    private String description;
    
    public About() { }
    
    public About(Integer id, String address, String email, 
            String phone, String fax, String description)
    {
        this.id=id;
        this.address=address;
        this.email=email;
        this.phone=phone;
        this.fax=fax;
        this.description=description;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name="id")
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the address
     */
     @Column(name="address")
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
     @Column(name="email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
     @Column(name="phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the fax
     */
     @Column(name="fax")
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the description
     */
     @Column(name="description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
            
}
