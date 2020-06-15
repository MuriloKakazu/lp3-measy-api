package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@SQLDelete(sql = "update playlist set is_deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
public class Playlist extends BaseEntity {
    @Column(name="owner_id")
    private UUID ownerId;

    @Column(name="image_url")
    private String imageUrl;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
    })
    @JoinTable(
            name = "playlist_entry",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private List<Track> tracks = new ArrayList<>();

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

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
