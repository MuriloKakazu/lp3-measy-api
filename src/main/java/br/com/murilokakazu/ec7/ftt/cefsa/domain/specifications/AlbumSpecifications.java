package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album_;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class AlbumSpecifications {

    public static Specification<Album> artistIdEquals(UUID artistId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Album_.artistId), artistId);
    }

}
