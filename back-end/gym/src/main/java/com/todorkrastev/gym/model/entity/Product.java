package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.ProductCategoryName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategoryName productCategoryName;
    private String file;

    //TODO: How to store pictures as jpeg or png files, instead of urls, in the database
    //TODO: If you are running out of time, just add to the database urls.


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

    @Column(name = "file", nullable = false)
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Column(name = "product_category_name", nullable = false)
    @Enumerated(EnumType.STRING)
    public ProductCategoryName getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(ProductCategoryName productCategoryName) {
        this.productCategoryName = productCategoryName;
    }
}
