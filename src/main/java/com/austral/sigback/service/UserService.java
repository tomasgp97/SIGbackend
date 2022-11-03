package com.austral.sigback.service;

import com.austral.sigback.dto.UserDto;
import com.austral.sigback.model.User;
import com.austral.sigback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User login(UserDto userDto) {
        Optional<User> optional = this.userRepository.findByEmail(userDto.getEmail());
        return optional.orElseThrow();
    }


}
