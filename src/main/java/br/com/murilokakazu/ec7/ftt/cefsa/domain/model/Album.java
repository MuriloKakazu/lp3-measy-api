package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
)
public class Album extends BaseEntity {
    @Column(name = "artist_id")
    private UUID artistId;

    @Type(type="string-array")
    private String[] genre;

    @Min(0)
    @Max(100)
    private Integer popularity;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="release_date")
    private OffsetDateTime releaseDate;

    @OneToMany(
            mappedBy="albumId",
            fetch=FetchType.EAGER
    )
    private List<Track> tracks = new ArrayList<>();

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OffsetDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(OffsetDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
