package com.example.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(callSuper = true, exclude="password")
@JsonIgnoreProperties({"new"})
public class User extends AbstractPersistable<Integer> {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 100)
    private String first_name;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 100)
    private String last_name;

    @NotBlank
    @Column(name = "password", nullable = false)
    @Size(min = 2, max = 25)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "id") //https://stackoverflow.com/a/62848296/548473
    private Set<Role> role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
