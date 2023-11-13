package com.igniteminds.copilotspring.web;

import com.igniteminds.copilotspring.model.Expense;
import com.igniteminds.copilotspring.model.ExpenseRepository;
import com.igniteminds.copilotspring.model.Group;
import com.igniteminds.copilotspring.model.GroupRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class ExpenseController {

    private final Logger log = LoggerFactory.getLogger(ExpenseController.class);
    private ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expenses")
    Collection<Expense> expenses() {
        return expenseRepository.findAll();
    }

    @GetMapping("/expense/{id}")
    ResponseEntity<?> getExpense(@PathVariable Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/expense")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException {
        log.info("Request to create group: {}", expense);
        Expense result = expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/api/expense/" + result.getId()))
                .body(result);
    }

    @PutMapping("/expense/{id}")
    ResponseEntity<Expense> updateExpense(@Valid @RequestBody Expense expense) {
        log.info("Request to update group: {}", expense);
        Expense result = expenseRepository.save(expense);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
