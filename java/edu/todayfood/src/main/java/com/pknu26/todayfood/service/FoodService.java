package com.pknu26.todayfood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pknu26.todayfood.dto.FoodDto;
import com.pknu26.todayfood.mapper.FoodMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodMapper foodMapper;

    public List<FoodDto> getAllFoods() {
        return foodMapper.findAll();
    }

    public FoodDto getFoodById(Long id) {
        return foodMapper.findById(id);
    }

    public void saveFood(FoodDto foodDto) {
        foodMapper.insert(foodDto);
    }

    public void updateFood(FoodDto foodDto) {
        foodMapper.update(foodDto);
    }

    public void deleteFood(Long id) {
        foodMapper.delete(id);
    }

    public List<FoodDto> getFoodsByCategory(String category) {
        return foodMapper.findByCategory(category);
    }

    public FoodDto getRandomFood() {
        return foodMapper.findRandomOne();
    }
}
