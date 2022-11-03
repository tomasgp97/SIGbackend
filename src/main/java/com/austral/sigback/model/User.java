package com.austral.sigback.model;

import com.austral.sigback.utils.Role;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column(name = "first_name", nullable = false)
//    @Size(max = 100)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    @Size(max = 100)
//    private String lastName;

    @Column(nullable = false, name = "password")
    @Size(max = 100)
    private String password;

    @Column(nullable = false, name = "email")
    @Size(max = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "job_user",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)})
//    private Set<Job> jobs = new HashSet<>();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Job> getJobs() {
//        return jobs;
//    }
//
//    public void setJobs(Set<Job> jobs) {
//        this.jobs = jobs;
//    }

}
