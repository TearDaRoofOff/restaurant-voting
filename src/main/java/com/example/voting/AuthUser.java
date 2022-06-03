package com.example.voting;

import com.example.voting.domain.User;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getEmail(), user.getPassword(), user.getRole());
        this.user = user;
    }

    public int id() {
        return user.getId();
    }
}
