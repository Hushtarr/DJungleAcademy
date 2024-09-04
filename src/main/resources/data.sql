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
                         isSaved BOOLEAN DEFAULT true,  -- Ensure default value
                         contact_type VARCHAR(50),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         created_by VARCHAR(255),
                         updated_by VARCHAR(255)
);



-- Insert sample data
INSERT INTO Contact (name, mobileNum, email, subject, message, isSaved, contact_type, created_at, updated_at, created_by, updated_by)
VALUES
    ('John Doe', '123-456-7890', 'john.doe@example.com', 'Inquiry about product',
     'I would like more information about your product.', TRUE, 'USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system', 'system'),
    ('Jane Smith', '987-654-3210', 'jane.smith@example.com', 'Feedback on service',
     'The service was great, but I have a suggestion.', TRUE, 'USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system', 'system'),
    ('Alice Johnson', '555-123-4567', 'alice.johnson@example.com', 'Complaint about order',
     'My recent order arrived damaged.', TRUE, 'ANONYMOUS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system', 'system'),
    ('Bob Brown', '555-987-6543', 'bob.brown@example.com', 'Support request',
     'I need assistance with my account.', TRUE, 'USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system', 'system'),
    ('Charlie Green', '555-555-5555', 'charlie.green@example.com', 'General inquiry',
     'Just reaching out to ask a few questions.', TRUE, 'USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'system', 'system');
