package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Playlist extends BaseEntity {
    @Column(name="owner_id")
    private UUID ownerId;

    @Column(name="image_url")
    private String imageUrl;

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
