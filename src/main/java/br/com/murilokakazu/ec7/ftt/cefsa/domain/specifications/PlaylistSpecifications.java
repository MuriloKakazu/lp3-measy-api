package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Playlist_;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class PlaylistSpecifications {

    public static Specification<Playlist> ownerIdEquals(UUID ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Playlist_.ownerId), ownerId);
    }
}
