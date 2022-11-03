package com.austral.sigback.model;

import com.austral.sigback.utils.ApplicationStatus;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name="speech")
    private String speech;

    @Column(name="contact")
    private String contact;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

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
