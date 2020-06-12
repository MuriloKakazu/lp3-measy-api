package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Artist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Artist_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class ArtistSpecifications {

    public static Specification<Artist> bySpecifications(Artist prototype) {
        List<Specification> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(idEquals(prototype.getId()));
        }

        if (prototype.getName() != null) {
            specifications.add(nameLike(prototype.getName()));
        }

        return (Specification<Artist>) (root, query, criteriaBuilder) -> {
            var predicates = specifications.stream().map(spec ->
                    spec.toPredicate(root, query, criteriaBuilder)).collect(toList());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Artist> idEquals(UUID id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Artist_.ID), id);
    }

    public static Specification<Artist> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Artist_.NAME)), '%' + name.toLowerCase() + '%');
    }

}
