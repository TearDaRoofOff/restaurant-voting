package com.example.voting;

import com.example.voting.domain.User;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    private int id;

    private User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRole());
        this.id = user.getId();
    }

    public static AuthUser get() {
        AuthUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public static AuthUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof AuthUser) ? (AuthUser) user : null;
    }

    public static int id() {
        return get().id;
    }


}
