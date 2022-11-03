package com.austral.sigback.dto;

public class DurationDto {
    private Long jobId;
    private Long applicationId;

    public DurationDto(Long jobId, Long applicationId) {
        this.jobId = jobId;
        this.applicationId = applicationId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
}
