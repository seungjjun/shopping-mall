package com.server.market.models.product.option;

import com.server.market.models.EntityId;

public class ProductOptionId extends EntityId {
    private ProductOptionId() {
        super();
    }

    public ProductOptionId(String value) {
        super(value);
    }

    public static ProductOptionId generate() {
        return new ProductOptionId(newTsid());
    }
}
