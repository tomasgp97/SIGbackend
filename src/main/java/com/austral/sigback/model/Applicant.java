package com.austral.sigback.model;

import javax.persistence.*;

@Entity()
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue()
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String applicationRequest;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApplicationRequest() {
        return applicationRequest;
    }

    public void setApplicationRequest(String applicationRequest) {
        this.applicationRequest = applicationRequest;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
