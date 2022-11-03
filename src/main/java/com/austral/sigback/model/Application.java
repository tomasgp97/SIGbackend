package com.austral.sigback.model;

import com.austral.sigback.utils.ApplicationStatus;

import javax.persistence.*;

@Entity()
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "status")
    private ApplicationStatus status;

    @Column(name = "jobid")
    private Long jobId;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

}
