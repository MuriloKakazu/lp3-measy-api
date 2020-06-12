package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class AccountSpecifications {

    public static Specification<Account> bySpecifications(Account prototype) {
        List<Specification> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(idEquals(prototype.getId()));
        }

        if (prototype.getName() != null) {
            specifications.add(nameLike(prototype.getName()));
        }

        if (prototype.getEmail() != null) {
            specifications.add(emailEquals(prototype.getEmail()));
        }

        return (Specification<Account>) (root, query, criteriaBuilder) -> {
            var predicates = specifications.stream().map(spec ->
                    spec.toPredicate(root, query, criteriaBuilder)).collect(toList());

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public static Specification<Account> idEquals(UUID id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Account_.ID), id);
    }

    public static Specification<Account> nameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get(Account_.NAME)), '%' + name.toLowerCase() + '%');
    }

    public static Specification<Account> emailEquals(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Account_.EMAIL), email);
    }

}
