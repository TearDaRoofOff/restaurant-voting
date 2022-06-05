package com.example.voting.web;

import com.example.voting.AuthUser;
import com.example.voting.domain.Menu;
import com.example.voting.domain.Restaurant;
import com.example.voting.service.VoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping(value = "/api/votes")
@AllArgsConstructor
@Slf4j
public class VoteController {
    private static final LocalTime EXPIRED_TIME = LocalTime.parse("11:00");

    private VoteService voteService;

    @GetMapping
    public ResponseEntity<Restaurant> current() {
        log.info("REST request for get all votes");
        return voteService.getByUserIdAndDate(AuthUser.id(), LocalDate.now())
                .map(vote -> new ResponseEntity<>(vote.getMenu().getRestaurant(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Restaurant> createVote(@PathVariable("id") Menu menu) {
        LocalDate today = LocalDate.now();
        if (menu == null || !menu.getDate().equals(today)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        int id = AuthUser.id();
        boolean expired = LocalTime.now().isAfter(EXPIRED_TIME);
        VoteService.VoteWithStatus voteWithStatus = expired ?
                voteService.saveIfAbsent(id, menu) :
                voteService.save(id, menu);
        return new ResponseEntity<>(voteWithStatus.getVote().getMenu().getRestaurant(),
                voteWithStatus.isCreated() ? HttpStatus.CREATED : (expired ? HttpStatus.CONFLICT : HttpStatus.OK));
    }
}
