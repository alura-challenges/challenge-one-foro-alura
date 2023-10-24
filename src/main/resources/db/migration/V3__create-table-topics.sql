CREATE TABLE TOPICS(
    id bigint NOT NULL AUTO_INCREMENT,
    title varchar(150) NOT NULL UNIQUE,
    message TEXT,
    creation_date datetime NOT NULL,
    status varchar(150) NOT NULL,
    author_id bigint NOT NULL,
    course_id bigint NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_topics_author FOREIGN KEY (author_id) REFERENCES users(id),
    CONSTRAINT fk_topics_course FOREIGN KEY (course_id) REFERENCES courses(id)
)