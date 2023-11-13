package com.igniteminds.copilotspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private Instant date;
    private String description;
    private double amount;

}