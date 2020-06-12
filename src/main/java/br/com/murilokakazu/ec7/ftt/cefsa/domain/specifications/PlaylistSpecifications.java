package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class PlaylistSpecifications {

    public static Specification<Playlist> bySpecifications(Playlist prototype) {
        List<Specification> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(idEquals(prototype.getId()));
        }

        if (prototype.getOwnerId() != null) {
            specifications.add(ownerIdEquals(prototype.getOwnerId()));
        }

        if (prototype.getName() != null) {
            specifications.add(nameLike(prototype.getName()));
        }

        return (Specification<Playlist>) (root, query, criteriaBuilder) -> {
            var predicates = specifications.stream().map(spec ->
                    spec.toPredicate(root, query, criteriaBuilder)).collect(toList());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Playlist> idEquals(UUID id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Playlist_.ID), id);
    }

    public static Specification<Playlist> ownerIdEquals(UUID ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Playlist_.ownerId), ownerId);
    }

    public static Specification<Playlist> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Playlist_.NAME)), '%' + name.toLowerCase() + '%');
    }
}
