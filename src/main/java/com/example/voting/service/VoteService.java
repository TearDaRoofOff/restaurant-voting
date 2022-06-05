package com.example.voting.service;

import com.example.voting.domain.Menu;
import com.example.voting.domain.Vote;
import com.example.voting.repository.UserRepository;
import com.example.voting.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService {

    private VoteRepository voteRepository;

    private UserRepository userRepository;

    public Optional<Vote> getByUserIdAndDate(int id, LocalDate localDate){
        return voteRepository.getByUserIdAndDate(id, localDate);
    }

    @Transactional
    public VoteWithStatus save(int userId, final Menu menu) {
        LocalDate date = menu.getDate();
        VoteWithStatus voteWithStatus = voteRepository.getByUserIdAndDate(userId, date)
                .map(v -> {
                    v.setMenu(menu);
                    return new VoteWithStatus(v, false);
                })
                .orElseGet(() -> new VoteWithStatus(
                        new Vote(date, menu, userRepository.getReferenceById(userId)), true));

        voteRepository.save(voteWithStatus.getVote());
        return voteWithStatus;
    }

    @Transactional
    public VoteWithStatus saveIfAbsent(int userId, final Menu menu) {
        LocalDate date = menu.getDate();
        return voteRepository.getByUserIdAndDate(userId, date)
                .map(v -> new VoteWithStatus(v, false))
                .orElseGet(() -> new VoteWithStatus(voteRepository.save(new Vote(date, menu, userRepository.getReferenceById(userId))), true));
    }


    public static class VoteWithStatus {
        private final Vote vote;
        private final boolean created;

        public VoteWithStatus(Vote vote, boolean updated) {
            this.vote = vote;
            this.created = updated;
        }

        public Vote getVote() {
            return vote;
        }

        public boolean isCreated() {
            return created;
        }
    }
}
