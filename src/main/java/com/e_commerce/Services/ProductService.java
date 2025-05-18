package com.e_commerce.Services;

import com.e_commerce.Dto.ProductDto;
import com.e_commerce.Entity.Category;
import com.e_commerce.Entity.Product;
import com.e_commerce.Repository.CategoryRepository;
import com.e_commerce.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        product.setId(null);
        product.setCategory(new Category(productDto.getCategoryId()));
        return productRepository.save(product);
    }

    public List<Product> createMiltipleProducts(List<ProductDto> productDtoList){

        List<Product> productList = new ArrayList<>();

        for (ProductDto productDto:productDtoList){
            Product product = modelMapper.map(productDto,Product.class);
            product.setId(null);
            product.setCategory(new Category(productDto.getCategoryId()));
            productList.add(product);
        }
        productRepository.saveAll(productList);
        return productList;
    }

    public Product updateProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto,Product.class);
        product.setCategory(new Category(productDto.getCategoryId()));
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(()-> new EntityNotFoundException("Product not found."));
    }

    public List<Product> getAllProductsByCategoryId(Long id){
        return productRepository.findProductByCategoryId(id);
    }

    public List<Product> getAllProductsByStockQuantity(Integer stockQuantity){
        return productRepository.findProductByStockQuantity(stockQuantity);
    }

    public void deleteProductById(Long id){
         productRepository.deleteById(id);
    }

    public List<Product> getLowerStockthan(Integer quantity){
        return productRepository.findByStockQuantityLessThan(quantity);
    }
    public List<Product> getHigherStockthan(Integer quantity){
        return productRepository.findByStockQuantityGreaterThan(quantity);
    }

    public Page<Product> getProductsPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
