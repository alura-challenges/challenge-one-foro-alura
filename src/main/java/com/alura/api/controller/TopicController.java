package com.alura.api.controller;

import com.alura.api.domain.topic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) { this.topicService = topicService; }

    @PostMapping
    public ResponseEntity<TopicDetailData> postNewTopic(@RequestBody @Valid TopicData registerTopic,
                                                        UriComponentsBuilder uriComponentsBuilder) {
        TopicDetailData topicCreated = topicService.create(registerTopic);
        URI url =uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topicCreated.id()).toUri();
        return ResponseEntity.created(url).body(topicCreated);
    }

    @GetMapping
    public ResponseEntity<Page<TopicListData>> getAllTopics(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicService.getAllTopics(paginacion).map(TopicListData::new));
    }


    @GetMapping("/{id}")
    public ResponseEntity<TopicListData> getTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicData> updateTopicById(@PathVariable Long id, @RequestBody TopicData topicData) {
        return  ResponseEntity.ok(topicService.updateTopicById(id, topicData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopicById(@PathVariable Long id) {
        topicService.deleteTopicById(id);
        return ResponseEntity.noContent().build();
    }


}
