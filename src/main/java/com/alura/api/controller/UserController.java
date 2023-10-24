package com.alura.api.controller;

import com.alura.api.domain.user.User;
import com.alura.api.domain.user.UserRegistrationData;
import com.alura.api.domain.user.UserRepository;
import com.alura.api.domain.user.UserResponseData;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository courseRepository) {
        this.userRepository = courseRepository;
    }

    @PostMapping
    public ResponseEntity<UserResponseData> createUser(@RequestBody @Valid UserRegistrationData userRegistrationData) {
        User user = userRepository.save(new User(userRegistrationData));
        UserResponseData userResponseData = new UserResponseData(user.getName());
        return ResponseEntity.ok(userResponseData);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
