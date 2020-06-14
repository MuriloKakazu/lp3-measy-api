package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Artist;
import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.Artist_;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;

public class ArtistSpecifications {

    public static Specification<Artist> matching(Artist prototype) {
        List<Specification<Artist>> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(isEqual(Artist_.ID, prototype.getId()));
        }

        if (prototype.getName() != null) {
            specifications.add(isEqual(Artist_.NAME, prototype.getName()));
        }

        return joinSpecifications(specifications);
    }

}
