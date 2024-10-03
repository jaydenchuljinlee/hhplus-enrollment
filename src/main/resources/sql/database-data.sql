INSERT INTO tutor (name, description, phone_number, email, created_at, updated_at, use_yn) VALUES
    ('토비', '스프링 전문가', '010-1234-5678', 'toby@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('엉클밥', '클린 코드 전문가', '010-9876-5432', 'unclebob@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('마크 주커버그', '페이스북 창업자', '010-1111-2222', 'zuckerberg@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');

INSERT INTO trainee (name, phone_number, email, created_at, updated_at, use_yn)
VALUES
    ('이철진', '010-3333-4444', 'abc123@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('이정기', '010-5555-6666', 'bcd234@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('이규명', '010-7777-8888', 'cde345@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('윤성민', '010-8888-9999', 'def456@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김현진', '010-9999-0000', 'efg567@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');


INSERT INTO lecture (tutor_id, capacity, date, open_yn, created_at, updated_at, use_yn)
VALUES
    (1, 30, '2024-10-01T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (1, 0, '2024-10-02T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (1, 30, '2024-10-03T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),

    (2, 30, '2024-10-01T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (2, 30, '2024-10-02T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (2, 0, '2024-10-03T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),

    (3, 0, '2024-10-01T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (3, 30, '2024-10-02T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (3, 30, '2024-10-03T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');
