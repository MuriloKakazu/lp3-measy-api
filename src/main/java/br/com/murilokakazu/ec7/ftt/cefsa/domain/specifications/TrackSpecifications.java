package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Track_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class TrackSpecifications {

    public static Specification<Track> bySpecifications(Track prototype) {
        List<Specification> specifications = new ArrayList<>(2);

        if (prototype.getId() != null) {
            specifications.add(idEquals(prototype.getId()));
        }
        if (prototype.getName() != null) {
            specifications.add(nameLike(prototype.getName()));
        }
        if (prototype.getAlbumId() != null) {
            specifications.add(albumIdEquals(prototype.getAlbumId()));
        }
        if (prototype.getArtistId() != null) {
            specifications.add(artistIdEquals(prototype.getArtistId()));
        }

        return (Specification<Track>) (root, query, criteriaBuilder) -> {
            var predicates = specifications.stream().map(spec ->
                    spec.toPredicate(root, query, criteriaBuilder)).collect(toList());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Track> idEquals(UUID id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Track_.id), id);
    }

    public static Specification<Track> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(Track_.name)), '%' + name.toLowerCase() + '%');
    }

    public static Specification<Track> albumIdEquals(UUID albumId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Track_.albumId), albumId);
    }

    public static Specification<Track> artistIdEquals(UUID artistId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Track_.artistId), artistId);
    }
}
