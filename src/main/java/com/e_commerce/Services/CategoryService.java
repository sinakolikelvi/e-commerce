package com.e_commerce.Services;

import com.e_commerce.Dto.CategoryDto;
import com.e_commerce.Entity.Category;
import com.e_commerce.Repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Category createCategory(CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto,Category.class);
        category.setId(null);
        return categoryRepository.save(category);
    }
    public Category getCategoryById(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElseThrow(()-> new EntityNotFoundException("Category not found!"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
