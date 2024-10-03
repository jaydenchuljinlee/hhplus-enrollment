----------------------------------------------------------------
-- 사용자 관련 테이블
----------------------------------------------------------------

-- 강의자 관련 테이블
CREATE TABLE tutor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    name VARCHAR(100) NOT NULL, -- 이름
    description TEXT, -- 강의자 설명
    phone_number VARCHAR(20) NOT NULL, -- 연락처
    email VARCHAR(100) NOT NULL, -- 이메일

    -- 베이스 필드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    use_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

-- 수강자 관련 테이블
CREATE TABLE trainee (
     id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
     name VARCHAR(100) NOT NULL, -- 이름
     phone_number VARCHAR(20) NOT NULL, -- 연락처
     email VARCHAR(100) NOT NULL, -- 이메일

    -- 베이스 필드
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
     use_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

----------------------------------------------------------------
-- 강의 관련 테이블
----------------------------------------------------------------

-- 수강 정보
CREATE TABLE lecture (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    tutor_id BIGINT NOT NULL, -- 강의 (외래 키: Lecture 테이블의 id)
    capacity INT DEFAULT 0, -- 수강 인원
    date TIMESTAMP NOT NULL, -- 신청일,
    open_yn CHAR(1) DEFAULT 'Y' NOT NULL, -- 개설 여부 (Y/N)

    -- 베이스 필드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    use_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);

-- 강의 신청 이력 관련 테이블
CREATE TABLE lecture_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키
    lecture_id BIGINT NOT NULL, -- 강의 (외래 키: Lecture 테이블의 id)
    trainee_id BIGINT NOT NULL, -- 수강자 (외래 키: Trainee 테이블의 trainere_no)
    accept_yn CHAR(1) DEFAULT 'N' NOT NULL, -- 수락 여부 (Y/N)
    cancel_yn CHAR(1) DEFAULT 'N' NOT NULL, -- 취소 여부 (Y/N)

    -- 베이스 필드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일
    use_yn CHAR(1) DEFAULT 'Y' NOT NULL -- 사용 여부 (Y/N)
);
