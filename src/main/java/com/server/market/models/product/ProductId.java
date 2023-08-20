package com.server.market.models.product;

import com.server.market.models.EntityId;

public class ProductId extends EntityId {
    private ProductId() {
        super();
    }

    public ProductId(String value) {
        super(value);
    }

    public static ProductId generate() {
        return new ProductId(newTsid());
    }
}
