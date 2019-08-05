create TABLE users
(
    id           SERIAL NOT NULL
        constraint users_pk primary key,
    created_date bigint,
    login        VARCHAR(45),
    first_name   VARCHAR(45),
    last_name    VARCHAR(45),
    full_name    VARCHAR(90),
    age          int
);

create TABLE role
(
    id   SERIAL NOT NULL
        constraint role_pk primary key,
    role VARCHAR(500)
);

create TABLE user_role
(
    user_id SERIAL,
    role_id SERIAL

);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE user_role
    ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role (id);


create TABLE course
(
    id           SERIAL NOT NULL
        constraint course_pk primary key,
    created_date bigint,
    name         VARCHAR(45),
    price        int
);

create TABLE section
(
    id           SERIAL NOT NULL
        constraint section_pk primary key,
    created_date bigint,
    name         VARCHAR(45),
    course_id    int
);


ALTER TABLE section
    ADD CONSTRAINT fk_section_id FOREIGN KEY (course_id) REFERENCES course (id);

create TABLE lesson
(
    id           SERIAL NOT NULL
        constraint lesson_pk primary key,
    created_date bigint,
    content      VARCHAR(500),
    section_id   int
);

create TABLE comment
(
    id           SERIAL NOT NULL
        constraint comment_pk primary key,
    created_date bigint,
    content      VARCHAR(500),
    lesson_id    int
);


ALTER TABLE comment
    ADD CONSTRAINT fk_comment_id FOREIGN KEY (lesson_id) REFERENCES lesson (id);