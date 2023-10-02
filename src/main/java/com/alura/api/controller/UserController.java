package com.alura.api.controller;

import com.alura.api.model.Course.Course;
import com.alura.api.model.Course.CourseData;
import com.alura.api.model.Course.CourseRepository;
import com.alura.api.model.Course.CourseResponseData;
import com.alura.api.model.user.User;
import com.alura.api.model.user.UserRegistrationData;
import com.alura.api.model.user.UserRepository;
import com.alura.api.model.user.UserResponseData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository courseRepository) {
        this.userRepository = courseRepository;
    }

    @PostMapping
    public ResponseEntity<UserResponseData> createUser(@RequestBody @Valid UserRegistrationData userRegistrationData ) {
        User user = userRepository.save(new User(userRegistrationData));
        UserResponseData userResponseData = new UserResponseData(user.getName());
        return ResponseEntity.ok(userResponseData);
    }
}
