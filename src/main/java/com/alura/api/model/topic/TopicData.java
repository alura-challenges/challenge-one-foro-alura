package com.alura.api.model.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicData(
        @NotNull
                @NotBlank
        String title,
        String message,
        @NotNull
        Long author,
        @NotNull
        Long course

) {

    public TopicData(Topic topicUpdated) {
        this(topicUpdated.getTitle(), topicUpdated.getMessage(),
                topicUpdated.getAuthor().getId(), topicUpdated.getCourse().getId());
    }
}
