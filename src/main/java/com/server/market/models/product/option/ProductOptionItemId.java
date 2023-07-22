package com.server.market.models.product.option;

import jakarta.persistence.Column;

public class ProductOptionItemId {
    @Column(name = "id")
    private String value;

    public ProductOptionItemId() {
    }

    public ProductOptionItemId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductOptionItemId{" +
            "value='" + value + '\'' +
            '}';
    }
}
