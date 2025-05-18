package com.e_commerce.Controller;

import com.e_commerce.Dto.CategoryDto;
import com.e_commerce.Entity.Category;
import com.e_commerce.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping("/add")
    public Category createCategory(@RequestBody CategoryDto categoryDto){
         return categoryService.createCategory(categoryDto);
    }
}
