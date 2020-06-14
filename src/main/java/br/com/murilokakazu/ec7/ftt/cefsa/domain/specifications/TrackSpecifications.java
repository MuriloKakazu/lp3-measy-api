package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track_;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;

public class TrackSpecifications {

    public static Specification<Track> matching(Track prototype) {
        List<Specification<Track>> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(isFieldEqual(Track_.ID, prototype.getId()));
        }
        if (prototype.getName() != null) {
            specifications.add(isFieldEqual(Track_.NAME, prototype.getName()));
        }
        if (prototype.getAlbumId() != null) {
            specifications.add(isFieldEqual(Track_.ALBUM_ID, prototype.getAlbumId()));
        }
        if (prototype.getArtistId() != null) {
            specifications.add(isFieldEqual(Track_.ARTIST_ID, prototype.getArtistId()));
        }

        return satisfyingAll(specifications);
    }

    public static Specification<Track> matching (String query) {
        return fieldContains(Track_.NAME, query);
    }
}
