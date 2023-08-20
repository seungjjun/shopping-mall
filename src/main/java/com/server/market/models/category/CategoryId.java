package com.server.market.models.category;

import com.server.market.models.EntityId;

public class CategoryId extends EntityId {
    private CategoryId() {
        super();
    }

    public CategoryId(String value) {
        super(value);
    }

    public static CategoryId generate() {
        return new CategoryId(newTsid());
    }
}
