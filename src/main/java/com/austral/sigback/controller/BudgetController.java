package com.austral.sigback.controller;


import com.austral.sigback.dto.BudgetDto;
import com.austral.sigback.model.Budget;
import com.austral.sigback.service.BudgetService;
import com.austral.sigback.utils.BudgetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        Budget saved = this.budgetService.saveBudget(budget);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets(@RequestParam(name = "status") BudgetStatus status) {
        List<Budget> budgets = this.budgetService.getBudgetByStatus(status);
        return new ResponseEntity<>(budgets, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Budget> updateBudget(@RequestBody BudgetDto dto) {
        Budget updated = this.budgetService.updateBudget(dto.getId(), dto.getStatus());
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
