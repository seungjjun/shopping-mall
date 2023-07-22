package com.server.market.models.product;

import jakarta.persistence.Column;

public class ProductId {
    @Column(name = "id")
    private String value;

    public ProductId() {
    }

    public ProductId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductId{" +
            "value='" + value + '\'' +
            '}';
    }
}
