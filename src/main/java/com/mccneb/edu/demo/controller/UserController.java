package com.mccneb.edu.demo.controller;

import com.mccneb.edu.demo.model.Login;
import com.mccneb.edu.demo.model.User;
import com.mccneb.edu.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User add) {
        return userService.addUser(add);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User update) {
        return userService.userUpdate(email, update);
    }
    //when you update it doesnt keep all the old data unless you put it in body??
    @DeleteMapping("/{email}")
    public ResponseEntity<User> deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Login userLogin) {
        return userService.login(userLogin);
    }


//    login endpoint where provider user password in body 401 if wrong passwrod 404 not found 200 ok
}
