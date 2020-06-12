package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Album_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class AlbumSpecifications {

    public static Specification<Album> bySpecifications(Album prototype) {
        List<Specification> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(idEquals(prototype.getId()));
        }

        if (prototype.getArtistId() != null) {
            specifications.add(artistIdEquals(prototype.getArtistId()));
        }

        if (prototype.getName() != null) {
            specifications.add(nameLike(prototype.getName()));
        }

        if (prototype.getReleaseDate() != null) {
            specifications.add(releaseDateEquals(prototype.getReleaseDate()));
        }

        return (Specification<Album>) (root, query, criteriaBuilder) -> {
            var predicates = specifications.stream().map(spec ->
                    spec.toPredicate(root, query, criteriaBuilder)).collect(toList());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Album> idEquals(UUID id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Album_.ID), id);
    }

    public static Specification<Album> artistIdEquals(UUID artistId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Album_.artistId), artistId);
    }

    public static Specification<Album> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Album_.NAME)), '%' + name.toLowerCase() + '%');
    }

    public static Specification<Album> releaseDateEquals(OffsetDateTime releaseDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Album_.RELEASE_DATE), releaseDate);
    }

}
