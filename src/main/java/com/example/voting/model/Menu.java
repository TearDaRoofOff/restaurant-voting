package com.example.voting.model;


import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Menu extends AbstractPersistable<Integer> {

    @Column(name = "menu_date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;
}
