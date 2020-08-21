INSERT INTO academy (name)
VALUES ('Institute of Physics'),
    ('Computer Science University');

INSERT INTO instructor (first_name, last_name, email, registration_date)
VALUES ('Bruce', 'Wayne', 'batman@example.com', CURRENT_DATE),
    ('Mary Jane', 'Watson', 'mj@watson.com', CURRENT_DATE),
    ('Lois', 'Lane', 'lois@lane.com', CURRENT_DATE);

INSERT INTO student (first_name, last_name, email, registration_date)
VALUES ('Cassandra', 'Cain', 'batgirl@example.com', CURRENT_DATE),
    ('Diana', 'Prince', 'wonderwoman@superhero.com', CURRENT_DATE),
    ('Matt', 'Murdock', 'daredevil@superhero.com', CURRENT_DATE);

INSERT INTO course (field, title, academy_id, instructor_id)
VALUES ('PHYSICS', 'Acoustics', 1, 1),
    ('MATHEMATICS', 'Calculus I', 1, 2),
    ('COMPUTER_SCIENCE', 'Object Oriented Programming', 2, 3),
    ('COMPUTER_SCIENCE', 'Algorithms I', 2, 1);

INSERT INTO course_student (course_id, student_id)
VALUES (1, 1), (1, 2), (2, 3),
    (2, 1), (3, 2), (3, 3),
    (4, 1), (4, 2);