package com.pknu26.studygroup.dto;

import lombok.Data;

// 페이지 요청할 때 필요한 값 계산
@Data
public class PageRequest {

    private int page = 1;  /// 현재 페이지
    private int size = 10; // 한 페이지당 게시글 수

    /*
    page1 일 때(1-1) * 10 = 0
    page2 일 때(2-1) * 10 = 10
    page3 일 때(3-1) * 10 = 20
    */
    public int getOffset() {
        return (page - 1) * size;
    }
}