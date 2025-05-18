package com.e_commerce.Controller;

import com.e_commerce.Dto.ProductDto;
import com.e_commerce.Entity.Product;
import com.e_commerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public void getProductById(@PathVariable Long id){
        productService.getProductById(id);
    }

    @PostMapping("/add")
    public void create(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductDto productDto){
        productService.updateProduct(productDto);
    }
}
