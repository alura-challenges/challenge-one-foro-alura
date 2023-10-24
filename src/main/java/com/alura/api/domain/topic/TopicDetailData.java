package com.alura.api.domain.topic;

public record TopicDetailData(
        Long id,
        String title,
        String Message
) {
    public TopicDetailData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage());
    }

}
