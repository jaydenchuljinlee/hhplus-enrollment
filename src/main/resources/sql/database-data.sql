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
    ('김현진', '010-9999-0000', 'efg567@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('허재', '010-1010-1111', 'ghi678@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('하헌우', '010-2020-3030', 'hij789@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('이석범', '010-4040-5050', 'klm890@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('타일러', '010-6060-7070', 'nop901@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('토투', '010-8080-9090', 'qrs012@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김종협', '010-2222-3333', 'tuv123@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('렌', '010-4444-5555', 'wxy234@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('박정환', '010-6666-7777', 'zab345@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김민재', '010-8888-0000', 'cde456@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('홍준상', '010-1212-3434', 'efg567@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김혜민', '010-5656-7878', 'ghi678@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('전소민', '010-9090-1212', 'jkl789@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('안예은', '010-2323-4545', 'mno890@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('신동엽', '010-6767-8989', 'pqr901@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('강호동', '010-3232-6565', 'stu012@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('이수근', '010-7474-9292', 'vwx123@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김희철', '010-8585-1313', 'yza234@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('유희열', '010-1212-5656', 'bcd345@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('장도연', '010-3434-7878', 'def456@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김민정', '010-5656-9090', 'ghi567@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김범수', '010-7878-2323', 'jkl678@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('박나래', '010-9090-4545', 'mno789@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('전현무', '010-4545-6767', 'pqr890@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김구라', '010-6767-8989', 'stu901@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김국진', '010-8989-3232', 'vwx012@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('이경규', '010-3232-5454', 'yza123@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('박경림', '010-5454-7676', 'bcd234@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('박미선', '010-7676-9898', 'def345@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김숙', '010-1212-4343', 'ghi456@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김지민', '010-3434-6565', 'jkl567@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('장동민', '010-5656-8787', 'mno678@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('정형돈', '010-7878-9898', 'pqr789@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('정준하', '010-8989-1212', 'stu890@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김용만', '010-2121-3434', 'vwx901@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('김태호', '010-4343-5656', 'yza012@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    ('중복 사용자', '010-4343-5656', 'yza012@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');




INSERT INTO lecture (id, tutor_id, capacity, date, open_yn, created_at, updated_at, use_yn)
VALUES
    (0,1, 30, '2024-10-06T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (1,1, 0, '2024-10-07T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (2,1, 30, '2024-10-08T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),

    (3,2, 30, '2024-10-06T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (4,2, 30, '2024-10-07T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (5,2, 0, '2024-10-08T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),

    (6,3, 0, '2024-10-06T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (7,3, 30, '2024-10-07T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y'),
    (8,3, 30, '2024-10-08T00:00:00', 'Y', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Y');
