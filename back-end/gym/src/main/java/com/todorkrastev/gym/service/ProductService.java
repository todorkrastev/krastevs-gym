package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ProductDTO;
import com.todorkrastev.gym.model.dto.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO getAllPosts(int pageNum, int pageSize, String sortBy, String sortDir);

    Long createProduct(ProductDTO newProduct);

    ProductDTO updateProductById(Long productId, ProductDTO productDTO);

    void deleteProductById(Long productId);

}
