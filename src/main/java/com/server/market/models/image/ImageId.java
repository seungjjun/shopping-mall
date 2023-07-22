package com.server.market.models.image;

import jakarta.persistence.Column;

public class ImageId {
    @Column(name = "id")
    private String value;

    public ImageId() {
    }

    public ImageId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ImageId{" +
            "value='" + value + '\'' +
            '}';
    }
}
