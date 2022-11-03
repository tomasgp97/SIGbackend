package com.austral.sigback.dto;

import com.austral.sigback.utils.ApplicationStatus;

public class ApplicationDto {
    private final Long id;
    private final ApplicationStatus status;

    public ApplicationDto(Long id, ApplicationStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public ApplicationStatus getStatus() {
        return status;
    }
}
