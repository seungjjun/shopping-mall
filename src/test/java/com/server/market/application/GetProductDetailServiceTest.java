package com.server.market.application;

import com.server.market.dtos.product.ProductDetailDto;
import com.server.market.models.category.Category;
import com.server.market.models.category.CategoryId;
import com.server.market.models.product.Money;
import com.server.market.models.product.Product;
import com.server.market.models.product.ProductId;
import com.server.market.repositories.CategoryRepository;
import com.server.market.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProductDetailServiceTest {
    private GetProductDetailService getProductDetailService;

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        categoryRepository = mock(CategoryRepository.class);

        getProductDetailService = new GetProductDetailService(productRepository, categoryRepository);
    }

    @Test
    void detail() {
        ProductId productId = new ProductId("A000001");
        CategoryId categoryId = new CategoryId("C000001");
        Product product = new Product(productId, categoryId, List.of(), "vaseline", new Money(3000L), List.of(), "description");

        Category category = new Category(categoryId, "category");

        given(productRepository.findById(any())).willReturn(Optional.of(product));
        given(categoryRepository.findById(any())).willReturn(Optional.of(category));

        ProductDetailDto productDetailDto = getProductDetailService.getProductDetailDto("A000001");

        assertThat(productDetailDto.name()).isEqualTo("vaseline");
        assertThat(productDetailDto.category().name()).isEqualTo("category");
        assertThat(productDetailDto.price()).isEqualTo(3000L);
    }
}
