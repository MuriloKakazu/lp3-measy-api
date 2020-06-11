package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import javax.persistence.Column;
import java.util.UUID;

public class Playlist {
    @Column(name="artist_id")
    private UUID artistId;

    @Column(name="album_id")
    private UUID albumId;

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
}
