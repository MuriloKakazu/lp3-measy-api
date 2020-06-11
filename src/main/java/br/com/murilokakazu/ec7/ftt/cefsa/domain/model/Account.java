package br.com.murilokakazu.ec7.ftt.cefsa.domain.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
public class Account extends BaseEntity {
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
