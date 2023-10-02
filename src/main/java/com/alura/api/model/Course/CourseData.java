package com.alura.api.model.Course;

import jakarta.validation.constraints.NotNull;

public record CourseData(
        @NotNull
        String courseCategory,
        @NotNull
        String formation,
        @NotNull
        String courseName
) {
}
