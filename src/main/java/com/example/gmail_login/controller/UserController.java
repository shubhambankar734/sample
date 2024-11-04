package com.example.gmail_login.controller;


import com.example.gmail_login.model.User;
import com.example.gmail_login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint to save a new user
    @CrossOrigin(origins = "*")
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Endpoint to authenticate a user by username and password
    @CrossOrigin(origins = "*")
    @GetMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.authenticateUser(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Endpoint to handle forgotten password scenario
    @CrossOrigin(origins = "*")
    @GetMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String username ) {
        User user = userService.findByUsername(username);
        if (user != null) {
            // In a real scenario, you would send an email or SMS with password reset instructions
            // Here, we just simulate that action with a response message
            return ResponseEntity.ok("Password reset instructions have been sent to your email.");
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
