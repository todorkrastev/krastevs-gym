package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.exception.ResourceNotFoundException;
import com.todorkrastev.gym.model.dto.ProductDTO;
import com.todorkrastev.gym.model.dto.ProductResponseDTO;
import com.todorkrastev.gym.model.entity.Product;
import com.todorkrastev.gym.repository.ProductRepository;
import com.todorkrastev.gym.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProductResponseDTO getAllPosts(int pageNum, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort); // Sort.by(sortBy).descending()

        Page<Product> products = this.productRepository.findAll(pageable);

        //get content for page object
        List<Product> listOfPosts = products.getContent();

        List<ProductDTO> content =
                listOfPosts
                        .stream()
                        .map(product -> this.modelMapper.map(product, ProductDTO.class))
                        .collect(Collectors.toList());

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setContent(content);
        productResponseDTO.setPageNum(products.getNumber());
        productResponseDTO.setPageSize(products.getSize());
        productResponseDTO.setTotalElements(products.getTotalElements());
        productResponseDTO.setTotalPages(products.getTotalPages());
        productResponseDTO.setLast(products.isLast());

        return productResponseDTO;
    }

    @Override
    public Long createProduct(ProductDTO newProduct) {
        Product productToSave = this.modelMapper.map(newProduct, Product.class);

        this.productRepository.save(productToSave);

        return productToSave.getId();
    }

    @Override
    public ProductDTO updateProductById(Long productId, ProductDTO productDTO) {
        //TODO: Make a validation if the admin is doing the change

        Product product = this.productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductCategoryName(productDTO.getProductCategoryName());
        product.setFile(productDTO.getFile());

        Product updatedProduct = this.productRepository.save(product);

        return this.modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProductById(Long productId) {
        Product product = this.productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

        this.productRepository.delete(product);
    }
}
