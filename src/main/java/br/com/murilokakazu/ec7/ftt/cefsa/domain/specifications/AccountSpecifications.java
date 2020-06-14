package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Account_;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;

public class AccountSpecifications {

    public static Specification<Account> matching(Account prototype) {
        List<Specification<Account>> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(isEqual(Account_.ID, prototype.getId()));
        }

        if (prototype.getName() != null) {
            specifications.add(isEqual(Account_.NAME, prototype.getName()));
        }

        if (prototype.getEmail() != null) {
            specifications.add(isEqual(Account_.EMAIL, prototype.getEmail()));
        }

        return joinSpecifications(specifications);
    }

    public static Specification<Account> matching(String query) {
        return containsCaseInsensitive(Account_.NAME, query);
    }

}
