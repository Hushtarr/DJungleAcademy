-- Drop the table if it exists
DROP TABLE IF EXISTS Contact;

-- Create the table
CREATE TABLE Contact (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         mobileNum VARCHAR(20),
                         email VARCHAR(255),
                         subject VARCHAR(255),
                         message TEXT,
                         message_type VARCHAR(50),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         created_by VARCHAR(255),
                         updated_by VARCHAR(255)
);

