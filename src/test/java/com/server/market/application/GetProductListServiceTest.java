package com.server.market.application;

import com.server.market.dtos.product.ProductListDto;
import com.server.market.models.category.Category;
import com.server.market.models.category.CategoryId;
import com.server.market.models.image.Image;
import com.server.market.models.image.ImageId;
import com.server.market.models.product.Money;
import com.server.market.models.product.Product;
import com.server.market.models.product.ProductId;
import com.server.market.models.product.option.ProductOption;
import com.server.market.models.product.option.ProductOptionId;
import com.server.market.repositories.CategoryRepository;
import com.server.market.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetProductListServiceTest {
    private GetProductListService getProductListService;

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        getProductListService = new GetProductListService(productRepository, categoryRepository);
    }

    @Test
    void product_list_categoryId_not_null() {
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
        List<Product> products = new ArrayList<>();
        products.add(product);

        given(productRepository.findAllByCategoryId(any())).willReturn(products);
        given(categoryRepository.findById(any())).willReturn(Optional.of(category));

        ProductListDto productListDto = getProductListService.getProductListDto("C000001");

        assertThat(productListDto.products()).hasSize(1);
        assertThat(productListDto.products().get(0).name()).isEqualTo("neat");
    }
}
