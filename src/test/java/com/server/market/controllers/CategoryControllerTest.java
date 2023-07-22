package com.server.market.controllers;

import com.server.market.application.GetCategoryListService;
import com.server.market.models.category.Category;
import com.server.market.models.category.CategoryId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetCategoryListService getCategoryListService;

    @Test
    @DisplayName("GET /categories")
    void list() throws Exception {
        Category category = new Category(new CategoryId("A00001"), "top");
        given(getCategoryListService.getCategories()).willReturn(List.of(category));

        mockMvc.perform(get("/categories"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("top")
            ));
    }
}
