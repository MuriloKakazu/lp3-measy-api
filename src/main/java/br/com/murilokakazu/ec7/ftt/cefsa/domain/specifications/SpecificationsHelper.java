package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.List;

import static br.com.murilokakazu.ec7.ftt.cefsa.infrastructure.formatter.SQLFormatter.*;
import static java.util.stream.Collectors.toList;

public class SpecificationsHelper {

    public static <T> Specification<T> joinSpecifications(List<Specification<T>> specifications) {
        return (root, query, criteriaBuilder) -> {
            var predicates = specifications.stream().map(spec ->
                    spec.toPredicate(root, query, criteriaBuilder)).collect(toList());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static <T, U> Specification<T> isEqual(String attributeName, U value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attributeName), value);
    }

    public static <T> Specification<T> containsCaseInsensitive(String attributeName, String value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(attributeName)), formatLowerCaseLikeContains(value));
    }

}
