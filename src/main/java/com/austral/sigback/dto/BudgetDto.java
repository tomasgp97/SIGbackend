package com.austral.sigback.dto;

import com.austral.sigback.utils.BudgetStatus;

public class BudgetDto {
    private final Long id;
    private final BudgetStatus status;

    public BudgetDto(Long id, BudgetStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public BudgetStatus getStatus() {
        return status;
    }
}
