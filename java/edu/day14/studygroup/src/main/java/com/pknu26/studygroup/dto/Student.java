package com.pknu26.studygroup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter // 멤버변수 getter, setter 메서드 자동생성
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 파라미터 생성자
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private String major;
    
}
