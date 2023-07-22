package com.server.market.dtos.category;

import com.server.market.models.category.Category;

public record CategoryDto(String id, String name) {
    public static CategoryDto of(Category category) {
        return new CategoryDto(category.id().toString(), category.name());
    }
}
