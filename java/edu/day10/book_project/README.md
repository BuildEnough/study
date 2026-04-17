# 260416 Java Spring 퀴즈 - book_mng

## 프로젝트 개요
Spring Boot + JPA + Thymeleaf + Oracle DB를 사용하여  
도서 정보를 관리하는 **CRUD 웹 애플리케이션**을 구현한다.

- **주제**: Book
- **프로젝트명**: `book_mng`
- **GroupId**: `com.pknu26`
- **ArtifactId**: `book_mng`
- **기술스택**
  - Spring Boot
  - Spring MVC
  - Spring Data JPA
  - Thymeleaf
  - Oracle Database
  - Lombok
  - Validation

---

## 요구사항
- 웹사이트 개발에 필요한 엔티티 중 **Book**을 선택
- **CRUD 기능 구현**
  - 도서 목록 조회
  - 도서 상세 조회
  - 도서 등록
  - 도서 수정
  - 도서 삭제
- JPA 방식으로 구현
- 전체 소스코드 제출

---

## 데이터베이스 설계
### BOOK 테이블 생성
```sql
CREATE TABLE BOOK (
    BOOK_ID        NUMBER PRIMARY KEY,          -- 도서 고유 ID (PK)
    TITLE          VARCHAR2(300) NOT NULL,      -- 책 제목
    AUTHOR         VARCHAR2(200),               -- 저자
    PUBLISHER      VARCHAR2(200),               -- 출판사
    ISBN           VARCHAR2(20) UNIQUE,         -- ISBN (고유값)
    CATEGORY       VARCHAR2(100),               -- 카테고리 (IT, 소설, 역사, 전쟁, 무협 등)
    PRICE          NUMBER,                      -- 가격
    STOCK          NUMBER DEFAULT 0,            -- 재고 수량
    PUBLISHED_DATE DATE,                        -- 출판일
    DESCRIPTION    CLOB,                        -- 책 설명
    CREATED_AT     DATE DEFAULT SYSDATE,        -- 생성일
    UPDATED_AT     DATE                         -- 수정일
);

CREATE SEQUENCE SEQ_BOOK
START WITH 1
INCREMENT BY 1
NOCACHE;
```
