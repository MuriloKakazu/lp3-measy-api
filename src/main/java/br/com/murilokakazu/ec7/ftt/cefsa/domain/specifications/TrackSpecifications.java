package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track_;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class TrackSpecifications {

    public static Specification<Track> albumIdEquals(UUID albumId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Track_.albumId), albumId);
    }

}
