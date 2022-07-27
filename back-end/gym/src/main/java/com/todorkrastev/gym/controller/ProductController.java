package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.ProductDTO;
import com.todorkrastev.gym.model.dto.ProductResponseDTO;
import com.todorkrastev.gym.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.todorkrastev.gym.util.AppConstants.*;
import static com.todorkrastev.gym.util.AppConstants.DEFAULT_SORT_DIRECTION;

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
    public ProductResponseDTO getAllProducts(
            @RequestParam(value = "pageNum", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return this.productService.getAllPosts(pageNum, pageSize, sortBy, sortDir);
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
