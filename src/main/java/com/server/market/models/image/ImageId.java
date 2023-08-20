package com.server.market.models.image;

import com.server.market.models.EntityId;

public class ImageId extends EntityId {
    private ImageId() {
        super();
    }

    public ImageId(String value) {
        super(value);
    }

    public static ImageId generate() {
        return new ImageId(newTsid());
    }
}
