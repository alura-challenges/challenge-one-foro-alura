package com.alura.api.domain.topic;

import com.alura.api.domain.course.Course;
import com.alura.api.domain.course.CourseRepository;
import com.alura.api.domain.user.User;
import com.alura.api.domain.user.UserRepository;
import com.alura.api.domain.topic.validators.IntegrityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;
    @Autowired
    public TopicService(
            TopicRepository topicRepository,
            UserRepository userRepository,
            CourseRepository courseRepository
    ) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public TopicDetailData create(TopicData registerTopic) {
        if(!topicRepository.findByTitle(registerTopic.title()).isEmpty()) {
            throw new IntegrityValidator("This title already exists");
        }
        if(!topicRepository.findByMessage(registerTopic.message()).isEmpty()) {
            throw new IntegrityValidator("This message already exists");
        }

        User author = userRepository.getReferenceById(registerTopic.author());
        Course course = courseRepository.getReferenceById(registerTopic.course());
        Topic topic = topicRepository.save(new Topic(registerTopic.title(),registerTopic.message(), author, course));

        return new TopicDetailData(topicRepository.save(topic));
    }


    public Page<Topic> getAllTopics(Pageable pageable) {
        List<Topic> topics = topicRepository.findAll();

        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();

        int fromIndex = pageNumber * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, topics.size());

        return new PageImpl<Topic>(topics.subList(fromIndex, toIndex), PageRequest.of(pageNumber, pageSize), topics.size());
    }

    public TopicListData getTopicById(Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        return new TopicListData(topic);
    }


    public TopicData updateTopicById(Long id, TopicData topicData) {
        if(id == null) {
            throw new IntegrityValidator("Id must not be null");
        }
        Topic topic = topicRepository.getReferenceById(id);
        User author = userRepository.getReferenceById(topicData.author());
        Course course = courseRepository.getReferenceById(topicData.course());

        Topic topicUpdated = topic.updateData(topicData, author, course);

        return new TopicData(topicUpdated);
    }

    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }
}
