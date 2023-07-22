package com.server.market.models.product.option;

import jakarta.persistence.Column;

public class ProductOptionId {
    @Column(name = "id")
    private String value;

    public ProductOptionId() {
    }

    public ProductOptionId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductOptionId{" +
            "value='" + value + '\'' +
            '}';
    }
}
