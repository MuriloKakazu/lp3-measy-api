package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album_;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;

public class AlbumSpecifications {

    public static Specification<Album> matching(Album prototype) {
        List<Specification<Album>> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(isFieldEqual(Album_.ID, prototype.getId()));
        }

        if (prototype.getArtistId() != null) {
            specifications.add(isFieldEqual(Album_.ARTIST_ID, prototype.getArtistId()));
        }

        if (prototype.getName() != null) {
            specifications.add(isFieldEqual(Album_.NAME, prototype.getName()));
        }

        if (prototype.getReleaseDate() != null) {
            specifications.add(isFieldEqual(Album_.RELEASE_DATE, prototype.getReleaseDate()));
        }

        return satisfyingAll(specifications);
    }

}
