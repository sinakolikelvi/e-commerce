package com.e_commerce.Services;

import com.e_commerce.Dto.ProductDto;
import com.e_commerce.Entity.Category;
import com.e_commerce.Entity.Product;
import com.e_commerce.Repository.CategoryRepository;
import com.e_commerce.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void createProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        product.setId(null);
        product.setCategory(new Category(productDto.getCategoryId()));
        productRepository.save(product);
    }
    public void updateProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);
        product.setCategory(new Category(productDto.getCategoryId()));
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Product getProductById(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(()-> new EntityNotFoundException("Product not found."));
    }
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
