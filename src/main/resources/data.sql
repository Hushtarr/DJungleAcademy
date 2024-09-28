INSERT INTO holidays (day, description, holiday_type)
VALUES
        ('Jan 1', 'New Year''s Day', 'FESTIVAL'),
        ('Oct 31', 'Halloween', 'FESTIVAL'),
        ('Nov 24', 'Thanksgiving Day', 'FESTIVAL'),
        ('Dec 25', 'Christmas', 'FESTIVAL'),
        ('Jan 17', 'Martin Luther King Jr. Day', 'FEDERAL'),
        ('Jul 4', 'Independence Day', 'FEDERAL'),
        ('Sep 5', 'Labor Day', 'FEDERAL'),
        ('Nov 11', 'Veterans Day', 'FEDERAL');


INSERT INTO users (id,first_name, last_name, user_name, password, email, phone, user_type, created_by, updated_by, created_at, updated_at,is_deleted)
VALUES
( 1,'John', 'Doe', 'johndoe', '$2a$10$6s9jJ3A08wIvvRi1cUqaW.AxC5z1aPswLXrd7w1WMEV8w5auk2EBu', 'johndoe@example.com', '123-456-7890', 'ADMIN', 'admin', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false),
( 2,'Jane', 'Smith', 'janesmith', '$2a$10$6s9jJ3A08wIvvRi1cUqaW.AxC5z1aPswLXrd7w1WMEV8w5auk2EBu', 'janesmith@example.com', '987-654-3210', 'INSTRUCTOR', 'admin', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false),
( 3,'Bob', 'Johnson', 'bobjohnson', '$2a$10$6s9jJ3A08wIvvRi1cUqaW.AxC5z1aPswLXrd7w1WMEV8w5auk2EBu', 'bobjohnson@example.com', '555-555-5555', 'STUDENT', 'admin', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false),
( 4,'Tom', 'Jackson', 'tomjackson', '$2a$10$6s9jJ3A08wIvvRi1cUqaW.AxC5z1aPswLXrd7w1WMEV8w5auk2EBu', 'tomjackson@example.com', '555-555-5555', 'PROFESSOR', 'admin', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false),
( 5,'Carl', 'Jhonson', 'cj', '$2a$10$6s9jJ3A08wIvvRi1cUqaW.AxC5z1aPswLXrd7w1WMEV8w5auk2EBu', 'cj@example.com', '555-555-5555', 'PROFESSOR', 'admin', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false),
( 6,'Cena', 'jk', 'janesmiths', '$2a$10$6s9jJ3A08wIvvRi1cUqaW.AxC5z1aPswLXrd7w1WMEV8w5auk2EBu', 'cena@example.com', '987-654-3210', 'INSTRUCTOR', 'admin', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,false)

;


INSERT INTO courses (name, professor_id,  created_at, updated_at, created_by, updated_by, is_deleted)
VALUES
--     ('Mathematics', 4,  NOW(), NOW(), 'admin', 'admin', FALSE),
    ('Physics', 5,  NOW(), NOW(), 'admin', 'admin', FALSE);
