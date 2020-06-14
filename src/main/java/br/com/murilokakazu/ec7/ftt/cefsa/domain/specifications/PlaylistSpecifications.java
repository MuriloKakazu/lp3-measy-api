package br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications;

import br.com.murilokakazu.ec7.ftt.cefsa.domain.model.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static br.com.murilokakazu.ec7.ftt.cefsa.domain.specifications.SpecificationsHelper.*;

public class PlaylistSpecifications {

    public static Specification<Playlist> matching(Playlist prototype) {
        List<Specification<Playlist>> specifications = new ArrayList<>();

        if (prototype.getId() != null) {
            specifications.add(isFieldEqual(Playlist_.ID, prototype.getId()));
        }
        if (prototype.getOwnerId() != null) {
            specifications.add(isFieldEqual(Playlist_.OWNER_ID, prototype.getOwnerId()));
        }
        if (prototype.getName() != null) {
            specifications.add(isFieldEqual(Playlist_.NAME, prototype.getName()));
        }

        return satisfyingAll(specifications);
    }

    public static Specification<Playlist> matching(String query) {
        return fieldContains(Playlist_.NAME, query);
    }
}
