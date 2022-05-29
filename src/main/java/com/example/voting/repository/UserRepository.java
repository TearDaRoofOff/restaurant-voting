package com.example.voting.repository;

import com.example.voting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "юзер", path = "chosen-one")
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(@Param("email") String email);

}