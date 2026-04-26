package com.pknu26.todayfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pknu26.todayfood.service.FoodService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FoodService foodService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("recommendFood", foodService.getRandomFood());
        return "index";
    }
}