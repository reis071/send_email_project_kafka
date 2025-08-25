package org.example.userservice.adapters.outbound.entities.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.example.userservice.domain.user.UserDomain;

import java.util.Objects;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Email
    private String email;

    public UserModel() {}

    public UserModel(UserDomain user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
