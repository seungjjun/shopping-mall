package com.server.market.models.image;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "images")
public class Image {
    @EmbeddedId
    private ImageId id;

    @Column(name = "url")
    private String url;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Image() {
    }

    public Image(ImageId id, String url) {
        this.id = id;
        this.url = url;
    }

    public ImageId id() {
        return id;
    }

    public String url() {
        return url;
    }
}
