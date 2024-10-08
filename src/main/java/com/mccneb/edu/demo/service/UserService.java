package com.mccneb.edu.demo.service;

import com.mccneb.edu.demo.model.Login;
import com.mccneb.edu.demo.model.User;
import com.mccneb.edu.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<User> findUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> addUser(User add) {
        add = userRepository.save(add);
        return ResponseEntity.ok(add);
    }

    public ResponseEntity<User> userUpdate(String email, User update) {
        Optional<User> updatedUser = userRepository.findById(email);
        if (updatedUser.isPresent()) {
            update = userRepository.save(update);
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> deleteUser(String email) {
        Optional<User> deletedUser = userRepository.findById(email);
        if (deletedUser.isPresent()) {
            userRepository.delete(deletedUser.get());
            return ResponseEntity.ok(deletedUser.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> login(Login userLogin) {
        Optional<User> optionalUser = userRepository.findById(userLogin.getUserEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (userLogin.getUserPassword().equals(user.getUserPassword())) {
                return ResponseEntity.ok(optionalUser.get());
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
