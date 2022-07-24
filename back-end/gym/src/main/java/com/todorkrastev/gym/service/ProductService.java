package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    Long createProduct(ProductDTO newProduct);

    ProductDTO updateProductById(Long productId, ProductDTO productDTO);

    void deleteProductById(Long productId);
}
