package com.server.market.dtos.product;

import com.server.market.dtos.category.CategoryDto;
import com.server.market.dtos.image.ImageDto;
import com.server.market.models.category.Category;
import com.server.market.models.product.Product;

public record ProductSummaryDto(String id,
                                CategoryDto categoryDto,
                                ImageDto thumbnail,
                                String name,
                                Long price) {
    public static ProductSummaryDto of(Product product, Category category) {
        return new ProductSummaryDto(
            product.id().toString(),
            CategoryDto.of(category),
            ImageDto.of(product.image(0)),
            product.name(),
            product.price().asLong());
    }
}
