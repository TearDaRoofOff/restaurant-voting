package com.example.voting.repository;

import com.example.voting.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    Optional<Vote> getByUserIdAndDate(int user_id, @NotNull LocalDate date);

}