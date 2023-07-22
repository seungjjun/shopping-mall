package com.server.market.controllers;

import com.server.market.application.GetCategoryListService;
import com.server.market.dtos.category.CategoryDto;
import com.server.market.dtos.category.CategoryListDto;
import com.server.market.models.category.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final GetCategoryListService getCategoryListService;

    public CategoryController(GetCategoryListService getCategoryListService) {
        this.getCategoryListService = getCategoryListService;
    }

    @GetMapping
    public CategoryListDto list() {
        List<Category> categories = getCategoryListService.getCategories();
        List<CategoryDto> categoryDtos = categories.stream()
            .map(this::mapToDto)
            .toList();

        return new CategoryListDto(categoryDtos);
    }

    private CategoryDto mapToDto(Category category) {
        return new CategoryDto(category.id().toString(), category.name());
    }
}
