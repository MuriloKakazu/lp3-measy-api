package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
)
@SQLDelete(sql = "update artist set is_deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
public class Artist extends BaseEntity {
    @Type(type="string-array")
    private String[] genre;

    @Min(0)
    @Max(100)
    private Integer popularity;

    @Column(name="image_url")
    private String imageUrl;

    @OneToMany(
            mappedBy="artistId",
            fetch= FetchType.EAGER
    )
    @Fetch(FetchMode.SELECT)
    private List<Album> albums = new ArrayList<>();

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

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

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
