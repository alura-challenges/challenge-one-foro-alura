package com.alura.api.controller;

import com.alura.api.model.course.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public ResponseEntity<CourseResponseData> createCourse(@RequestBody @Valid CourseData courseData) {
        Course course = courseRepository.save(new Course(courseData));
        CourseResponseData courseResponseData = new CourseResponseData(course.getName(),
                                                course.getCategory(),
                                                course.getFormation());
        return ResponseEntity.ok(courseResponseData);
    }


}
