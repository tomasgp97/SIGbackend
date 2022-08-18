package com.austral.sigback.repository;

import com.austral.sigback.model.Applicant;
import com.austral.sigback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Applicant> findByEmail(String email);
}
