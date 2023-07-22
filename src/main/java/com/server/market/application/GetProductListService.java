package com.server.market.application;

import com.server.market.dtos.product.ProductListDto;
import com.server.market.dtos.product.ProductSummaryDto;
import com.server.market.models.category.Category;
import com.server.market.models.category.CategoryId;
import com.server.market.models.product.Product;
import com.server.market.repositories.CategoryRepository;
import com.server.market.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductListService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public GetProductListService(ProductRepository productRepository,
                                 CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductListDto getProductListDto(String categoryId) {
        List<Product> products = findProducts(categoryId);

        List<ProductSummaryDto> productSummaryDtos = products.stream()
            .map(product -> {
                Category category = categoryRepository.findById(product.categoryId())
                    .get();

                return ProductSummaryDto.of(product, category);
            })
            .toList();

        return new ProductListDto(productSummaryDtos);
    }

    private List<Product> findProducts(String categoryId) {
        if (categoryId == null) {
            return productRepository.findAll();
        }

        CategoryId id = new CategoryId(categoryId);
        return productRepository.findAllByCategoryId(id);
    }
}
