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

INSERT INTO users (first_name, last_name, user_name, password, email, phone, created_at, updated_at, created_by, updated_by)
VALUES
        ('John', 'Doe', 'johndoe', 'password123', 'john.doe@example.com', '555-1234', '2024-09-01 10:15:30', '2024-09-01 10:15:30', 'anonymousUser', 'anonymousUser'),
        ('Jane', 'Smith', 'janesmith', 'password456', 'jane.smith@example.com', '555-5678', '2024-09-02 11:20:45', '2024-09-02 11:20:45', 'anonymousUser', 'anonymousUser'),
        ('Alice', 'Johnson', 'alicejohnson', 'password789', 'alice.johnson@example.com', '555-8765', '2024-09-03 12:25:50', '2024-09-03 12:25:50', 'anonymousUser', 'anonymousUser'),
        ('Bob', 'Brown', 'bobbrown', 'password321', 'bob.brown@example.com', '555-4321', '2024-09-04 13:30:55', '2024-09-04 13:30:55', 'anonymousUser', 'anonymousUser'),
        ('Carol', 'Williams', 'carolwilliams', 'password654', 'carol.williams@example.com', '555-1357', '2024-09-05 14:35:00', '2024-09-05 14:35:00', 'anonymousUser', 'anonymousUser');

--
-- INSERT INTO roles (description)
-- VALUES
--         ('ADMIN'),
--         ('STUDENT');