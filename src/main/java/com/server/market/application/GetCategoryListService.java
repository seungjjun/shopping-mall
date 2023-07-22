package com.server.market.application;

import com.server.market.models.Category;
import com.server.market.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategoryListService {
    private final CategoryRepository categoryRepository;

    public GetCategoryListService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
