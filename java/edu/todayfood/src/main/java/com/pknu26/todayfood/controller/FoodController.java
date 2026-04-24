package com.pknu26.todayfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.todayfood.dto.FoodDto;
import com.pknu26.todayfood.service.FoodService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("foods", foodService.getAllFoods());
        return "food/list";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("food", new FoodDto());
        return "food/form";
    }

    @PostMapping
    public String save(@ModelAttribute FoodDto foodDto) {
        foodService.saveFood(foodDto);
        return "redirect:/foods";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodService.getFoodById(id));
        return "food/detail";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodService.getFoodById(id));
        return "food/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute FoodDto foodDto) {
        foodDto.setId(id);
        foodService.updateFood(foodDto);
        return "redirect:/foods/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "redirect:/foods";
    }

    @GetMapping("/category/{category}")
    public String category(@PathVariable String category, Model model) {
        model.addAttribute("foods", foodService.getFoodsByCategory(category));
        model.addAttribute("title", category + " 목록");
        return "food/list";
    }
}