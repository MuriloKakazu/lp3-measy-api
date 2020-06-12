package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account extends BaseEntity {
    @Email
    private String email;

    @OneToMany(
            mappedBy="ownerId",
            fetch= FetchType.EAGER
    )
    @Fetch(FetchMode.SELECT)
    private List<Playlist> playlists = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
