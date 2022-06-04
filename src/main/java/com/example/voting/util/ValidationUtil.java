package com.example.voting.util;

import com.example.voting.domain.User;

public class ValidationUtil {

        public static void checkNew(User entity) {
                if (!entity.isNew()) {
                        throw new IllegalArgumentException(entity + " must be new (id=null)");
                    }
            }

    public static void assureIdConsistent(User user, int id) {
                if (user.isNew()) {
                        user.setId(id);
                    } else if (user.getId() != id) {
                        throw new IllegalArgumentException(user + " must has id=" + id);
                    }
            }
}
