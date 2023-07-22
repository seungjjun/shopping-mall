package com.server.market.controllers;

import com.server.market.application.GetProductListService;
import com.server.market.dtos.product.ProductListDto;
import com.server.market.dtos.product.ProductSummaryDto;
import com.server.market.models.category.Category;
import com.server.market.models.category.CategoryId;
import com.server.market.models.image.Image;
import com.server.market.models.image.ImageId;
import com.server.market.models.product.Money;
import com.server.market.models.product.Product;
import com.server.market.models.product.ProductId;
import com.server.market.models.product.option.ProductOption;
import com.server.market.models.product.option.ProductOptionId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductListService getProductListService;

    @Test
    @DisplayName("GET /products")
    void list() throws Exception {
        CategoryId categoryId = new CategoryId("C000001");
        Category category = new Category(categoryId, "top");

        Product product = new Product(
            new ProductId("A000001"),
            categoryId,
            List.of(new Image(new ImageId("I000001"), "imageUrl")),
            "neat",
            new Money(1000L),
            List.of(new ProductOption(new ProductOptionId("O000001"), "color", List.of())),
            "clothes"
        );

        ProductListDto productListDto = new ProductListDto(List.of(ProductSummaryDto.of(product, category)));
        given(getProductListService.getProductListDto(any())).willReturn(productListDto);

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("neat")
            ));
    }
}
