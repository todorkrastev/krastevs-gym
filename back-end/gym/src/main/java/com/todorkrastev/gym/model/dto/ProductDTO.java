package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.ProductCategoryName;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategoryName productCategoryName;
    private String file;

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
