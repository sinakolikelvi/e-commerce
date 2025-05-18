package com.e_commerce.Controller;

import com.e_commerce.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;
}
