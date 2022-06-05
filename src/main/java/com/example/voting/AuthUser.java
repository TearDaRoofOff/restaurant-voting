package com.example.voting;

import com.example.voting.domain.User;
import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import static java.util.Objects.requireNonNull;

@Getter
public class AuthUser extends org.springframework.security.core.userdetails.User {
    static final long serialVersionUID = 1L;

    private final int id;

    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRole());
        Assert.notNull(user.getId(), "Entity must has id");
        this.id = user.getId();
        this.user = user;
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
