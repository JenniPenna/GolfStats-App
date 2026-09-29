CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()

);

CREATE TABLE course (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    holes_count INT NOT NULL DEFAULT 18
);

CREATE TABLE course_hole (
    id BIGSERIAL PRIMARY KEY,
    course_id BIGINT NOT NULL REFERENCES course(id) ON DELETE CASCADE,
    hole_number INT NOT NULL,
    par INT NOT NULL,
    stroke_index INT,
    lenght_m INT,
    UNIQUE(course_id, hole_number)
);

CREATE TABLE round (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES app_user(id),
    course_id BIGINT NOT NULL REFERENCES course(id),
    played_on DATE NOT NULL,
    notes TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE hole_score (
    id BIGSERIAL PRIMARY KEY,
    round_id BIGINT NOT NULL REFERENCES round(id) ON DELETE CASCADE,
    hole_number INT NOT NULL,
    strokes INT NOT NULL,
    putts INT,
    penalties INT NOT NULL DEFAULT 0,
    fairway_hit BOOLEAN,
    green_in_regulation BOOLEAN,
    UNIQUE (round_id, hole_number)
);