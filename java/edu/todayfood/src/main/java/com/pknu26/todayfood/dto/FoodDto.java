package com.pknu26.todayfood.dto;

import lombok.Data;

@Data
public class FoodDto {
    private Long id;
    private String name;
    private String category;
    private Integer rating;
    private String memo;
    private String eatDate;
    private String createdAt;
}