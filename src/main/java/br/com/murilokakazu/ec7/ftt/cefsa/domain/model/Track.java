package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
public class Track extends BaseEntity {
    @Column(name="artist_id")
    private UUID artistId;

    @Column(name="album_id")
    private UUID albumId;

    @Min(0)
    @Max(100)
    private Integer popularity;

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }

    public UUID getAlbumId() {
        return albumId;
    }

    public void setAlbumId(UUID albumId) {
        this.albumId = albumId;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}
