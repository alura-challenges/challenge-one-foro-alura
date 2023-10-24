package com.alura.api.domain.topic;

import com.alura.api.domain.course.Course;
import com.alura.api.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topics")
@Entity(name = "Topic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate = LocalDateTime.now();

	private String status = TopicStatus.NO_RESPONDIDO.toString();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private User author;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	@Embedded
	private List<Object> answers = new ArrayList<>();

	public Topic(String title, String message, User author, Course course) {
		this.title = title;
		this.message = message;
		this.author = author;
		this.course = course;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Topic updateData(TopicData topicData, User author, Course course) {
		if(topicData.title() != null) {
			this.title = topicData.title();
		}
		if(topicData.message() != null) {
			this.message = topicData.message();
		}
		if(author != null) {
			this.author = author;
		}
		if(course != null) {
			this.course = course;
		}
		return this;
	}
}
