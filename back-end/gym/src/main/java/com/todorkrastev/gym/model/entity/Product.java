package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.ProductCategoryName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategoryName productCategoryName;

    //TODO: How to store pictures in the database

    public Product() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TINYTEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public ProductCategoryName getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(ProductCategoryName productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
}
