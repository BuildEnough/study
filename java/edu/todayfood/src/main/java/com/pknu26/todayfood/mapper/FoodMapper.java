package com.pknu26.todayfood.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pknu26.todayfood.dto.FoodDto;

@Mapper
public interface FoodMapper {
    List<FoodDto> findAll();
    FoodDto findById(Long id);
    int insert(FoodDto foodDto);
    int update(FoodDto foodDto);
    int delete(Long id);
    List<FoodDto> findByCategory(String category);
    FoodDto findRandomOne();
}
