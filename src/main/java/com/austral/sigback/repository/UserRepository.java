package com.austral.sigback.repository;

import com.austral.sigback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findByUsernameStartingWith(String username);
}
