package com.server.market.application;

import com.server.market.models.Category;
import com.server.market.models.CategoryId;
import com.server.market.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetCategoryListServiceTest {
    private CategoryRepository categoryRepository;

    private GetCategoryListService getCategoryListService;

    @BeforeEach
    void setUp() {
        categoryRepository = mock(CategoryRepository.class);

        getCategoryListService = new GetCategoryListService(categoryRepository);
    }

    @Test
    void list() {
        Category category = new Category(new CategoryId("A000001"), "top");
        given(categoryRepository.findAll()).willReturn(List.of(category));

        List<Category> categories = getCategoryListService.getCategories();

        assertThat(categories).hasSize(1);
    }
}
