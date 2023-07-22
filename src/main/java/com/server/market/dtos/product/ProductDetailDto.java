package com.server.market.dtos.product;

import com.server.market.dtos.category.CategoryDto;
import com.server.market.dtos.image.ImageDto;
import com.server.market.models.category.Category;
import com.server.market.models.product.Product;

import java.util.List;

public record ProductDetailDto(
    String id,
    CategoryDto category,
    List<ImageDto> images,
    String name,
    Long price,
    List<ProductOptionDto> options,
    String description
) {
    public static ProductDetailDto of(Product product, Category category) {
        return new ProductDetailDto(
            product.id().toString(),
            CategoryDto.of(category),
            product.images().stream().map(ImageDto::of).toList(),
            product.name(),
            product.price().asLong(),
            product.options().stream().map(ProductOptionDto::of).toList(),
            product.description());
    }
}
