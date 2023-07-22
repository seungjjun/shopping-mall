package com.server.market.application;

import com.server.market.dtos.product.ProductDetailDto;
import com.server.market.models.category.Category;
import com.server.market.models.product.Product;
import com.server.market.models.product.ProductId;
import com.server.market.repositories.CategoryRepository;
import com.server.market.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductDetailService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public GetProductDetailService(ProductRepository productRepository,
                                   CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDetailDto getProductDetailDto(String productId) {
        ProductId id = new ProductId(productId);
        Product product = productRepository.findById(id).orElseThrow();
        Category category = categoryRepository.findById(product.categoryId()).orElseThrow();

        return ProductDetailDto.of(product, category);
    }
}
