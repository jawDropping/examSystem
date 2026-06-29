CREATE TABLE user_exams(
    id UUID PRIMARY KEY NOT NULL,
    exam_id UUID NOT NULL,
    user_id UUID NOT NULL,
    date_taken TIMESTAMPTZ NOT NULL,
    status VARCHAR(50) NOT NULL CHECK(status IN ('PENDING', 'COMPLETED', 'CANCELLED')),

    CONSTRAINT fk_user_exams_exam FOREIGN KEY (exam_id) REFERENCES exam(id),
    CONSTRAINT fk_user_exams_user FOREIGN KEY (user_id) REFERENCES users(id)
)