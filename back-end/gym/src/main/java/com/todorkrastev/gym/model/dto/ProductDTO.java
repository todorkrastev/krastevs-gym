package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.ProductCategoryName;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private ProductCategoryName productCategoryName;
    private String file;

    public ProductDTO() {
    }

    @NotBlank(message = "Name must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Description must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Description must have at least 1 character!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Price must not be null!")
    @DecimalMin(value = "0.01", message = "Price must be over 0!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "You must select the category!")
    public ProductCategoryName getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(ProductCategoryName productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @NotNull(message = "You must select the file!")
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
