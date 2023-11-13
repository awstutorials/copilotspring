package com.igniteminds.copilotspring;

import com.igniteminds.copilotspring.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;
    private final ExpenseRepository expenseRepository;

    public Initializer(GroupRepository repository, ExpenseRepository expenseRepository) {
        this.repository = repository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Seattle JUG", "Denver JUG", "Dublin JUG",
                "London JUG").forEach(name ->
                repository.save(new Group(name))
        );

        Group djug = repository.findByName("Seattle JUG");
        Event e = Event.builder().title("Micro Frontends for Java Developers")
                .description("JHipster now has microfrontend support!")
                .date(Instant.parse("2022-09-13T17:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        Stream.of("expense 1", "expense 2", "expense 3",
                "expense 4").forEach(name ->
                expenseRepository.save(new Expense(name))
        );

        Expense expense1 = expenseRepository.findByName("expense 1");
        expense1.setAmount(100);
        expense1.setDate(Instant.now());
        expense1.setDescription("Sample description");
        expenseRepository.save(expense1);


        repository.findAll().forEach(System.out::println);
        expenseRepository.findAll().forEach(System.out::println);
    }
}