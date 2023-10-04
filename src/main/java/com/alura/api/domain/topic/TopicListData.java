package com.alura.api.domain.topic;

import com.alura.api.domain.course.CourseResponseData;
import com.alura.api.domain.user.UserResponseData;

import java.time.LocalDateTime;

public record TopicListData(
    String title,
    String message,
    LocalDateTime creationDate,
    String status,
    UserResponseData author,
    CourseResponseData course
) {
    public TopicListData(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(),
                new UserResponseData(topic.getAuthor().getName()),
                new CourseResponseData(topic.getCourse().getName(), topic.getCourse().getFormation(), topic.getCourse().getCategory()));
    }

}
