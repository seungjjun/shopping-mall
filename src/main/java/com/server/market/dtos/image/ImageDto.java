package com.server.market.dtos.image;

import com.server.market.models.image.Image;

public record ImageDto(String url) {
    public static ImageDto of(Image image) {
        return new ImageDto(image.url());
    }
}
