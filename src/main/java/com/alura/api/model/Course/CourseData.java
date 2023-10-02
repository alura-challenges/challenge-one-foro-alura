package com.alura.api.model.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseData(
        @NotNull
                @NotBlank
        String courseCategory,
        @NotNull
                @NotBlank
        String formation,
        @NotNull
                @NotBlank
        String courseName
) {
}
