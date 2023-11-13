package com.igniteminds.copilotspring.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense findByName(String name);
}