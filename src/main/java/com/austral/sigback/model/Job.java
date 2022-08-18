package com.austral.sigback.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job")
public class Job {


    @Id
    @GeneratedValue()
    @Column(name = "job_id")
    private Long id;

    private String description;

    private String requirements;

    @OneToMany(mappedBy = "applicant")
    private List<Applicant> applicants;

    @ManyToMany(mappedBy = "users")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
}
