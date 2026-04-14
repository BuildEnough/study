package com.pknu26.webboard.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

/*
class Board는 DB 테이블 Board로 생성
클래스 멤버필드가 전부 테이블 컬럼으로 생성
어노테이션이 이 역할을 수행
*/

@Entity // JPA 테이블 매핑 선언
@Getter // getter 메서드를 필드 별로 자동 생성
@Setter // setter 메서드를 자동 생성
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
    @SequenceGenerator(name = "board_seq", sequenceName = "board_seq", allocationSize = 1) // 서버 재시작 시 1씩 증가
    private Long bno; // 테이블 Board의 PK, Long -> H2 BIGINT 타입

    @Column(length = 250)
    private String title; // 게시판 제목

    // @Column(length = 8000) // Oracle에서는 varchar(4000)이상 못 씀
    @Lob // Large Of Byte
    private String content; // 게시글 내용

    @CreatedDate // 생성일자
    @Column(updatable = false) // 최초 작성시 생성 후 수정 X
    private LocalDateTime createDate; // 게시글 작성일

    @LastModifiedDate // 수정될 때마다 날짜 변경
    private LocalDateTime modifyDate; // 게시글 수정일

    // 핵심 ERD 부모:자식 관계 1:N 만드는 방법
    // mappedBy: 실제 테이블 board하고 연결
    // cascade: 부모테이블의 특정 데이터를 지우면, 자식 테이블의 연결된 데이터도 모두 삭제
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Reply> replyList = new ArrayList<>();
}
