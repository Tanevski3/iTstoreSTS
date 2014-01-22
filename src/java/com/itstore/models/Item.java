package com.itstore.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * @author Tanevski
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

    public Item() {
    }

    public Item(Integer id, String title, String specification,
            String description, String imageSource, Integer price,
            Integer stock, Date postDate,
            Category category, User user) {
        this.id = id;
        this.title = title;
        this.specification = specification;
        this.description = description;
        this.imageSource = imageSource;
        this.price = price;
        this.postDate = postDate;
        this.category = category;
        this.user = user;
        this.stock = stock;
    }
    private Integer id;
    private String title;
    private String specification;
    private String description;
    private String imageSource;
    private Integer price;
    private Integer stock;
    private Date postDate;
    private Category category;
    private User user;

    /**
     * @return the id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue()
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
     * @return the title
     */
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the specification
     */
    @Column(name = "specification")
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification the specification to set
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return the description
     */
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the imageSource
     */
    @Column(name = "image_source")
    public String getImageSource() {
        return imageSource;
    }

    /**
     * @param imageSource the image to set
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    /**
     * @return the price
     */
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the user
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the stock
     */
    @Column(name = "stock")
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return the postDate
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "post_date")
    @DateTimeFormat(pattern="YYYY-MM-DD")
    public Date getPostDate() {
        return postDate;
    }

    /**
     * @param postDate the postDate to set
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

}
