package com.austral.sigback.service;

import com.austral.sigback.model.Budget;
import com.austral.sigback.repository.BudgetRepository;
import com.austral.sigback.utils.BudgetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget saveBudget(Budget budget) {
        budget.setStatus(BudgetStatus.REVIEW);

        return this.budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return this.budgetRepository.findAll().stream().filter(b -> b.getStatus().equals(BudgetStatus.REVIEW)).collect(Collectors.toList());
    }

    public List<Budget> getApprovedBudgets() {
        return this.budgetRepository.findAll().stream().filter(b -> b.getStatus().equals(BudgetStatus.APPROVED)).collect(Collectors.toList());
    }

    public Budget updateBudget(Budget budget) {
        Optional<Budget> budgetOptional = this.budgetRepository.findById(budget.getId());
        budgetOptional.ifPresent(value -> value.setStatus(budget.getStatus()));
        return this.budgetRepository.save(budgetOptional.get());
    }

}
