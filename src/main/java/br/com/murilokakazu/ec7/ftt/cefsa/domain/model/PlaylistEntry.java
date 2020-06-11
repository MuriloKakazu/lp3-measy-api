package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class PlaylistEntry extends BaseEntity {
    @Column(name="playlist_id")
    private UUID playlistId;

    @Column(name="track_id")
    private UUID trackId;

    public UUID getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public void setTrackId(UUID trackId) {
        this.trackId = trackId;
    }
}
