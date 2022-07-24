package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.ProductDTO;
import com.todorkrastev.gym.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity
                .ok(this.productService.findAll());
    }

    @PostMapping("/add-product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO newProduct,
                                                    UriComponentsBuilder uriComponentsBuilder) {
        //TODO: throw an exception if so tries to create the same product which is already in the DB
        Long newProductId = this.productService.createProduct(newProduct);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/products/{id}")
                        .build(newProductId))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable("id") Long productId,
                                                        @RequestBody ProductDTO productDTO) {
        //TODO: Make a validation if the admin is doing the change

        ProductDTO productResponse = this.productService.updateProductById(productId, productDTO);

        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable("id") Long productId) {
        this.productService.deleteProductById(productId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
