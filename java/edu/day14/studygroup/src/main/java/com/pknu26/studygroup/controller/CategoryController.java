package com.pknu26.studygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.studygroup.dto.Category;
import com.pknu26.studygroup.dto.LoginUser;
import com.pknu26.studygroup.service.CategoryService;
import com.pknu26.studygroup.validation.CategoryForm;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 목록
    @GetMapping
    public String list(Model model, HttpSession session) {
        checkAdmin(session);
        model.addAttribute("categoryList", categoryService.getCategoryList());
        return "admin/category/list";
    }

    // 등록 폼
    @GetMapping("/create")
    public String createForm(Model model, HttpSession session) {
        checkAdmin(session);
        model.addAttribute("categoryForm", new CategoryForm());
        return "admin/category/form";
    }

    // 등록 처리
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("categoryForm") CategoryForm categoryForm,
                         BindingResult bindingResult,
                         HttpSession session) {
        checkAdmin(session);

        if (bindingResult.hasErrors()) {
            return "admin/category/form";
        }

        categoryService.createCategory(categoryForm);
        return "redirect:/admin/categories";
    }

    // 수정 폼
    @GetMapping("/edit/{categoryId}")
    public String editForm(@PathVariable("categoryId") Long categoryId,
                           Model model,
                           HttpSession session) {
        checkAdmin(session);

        Category category = categoryService.getCategory(categoryId);

        CategoryForm categoryForm = new CategoryForm();
        categoryForm.setCategoryId(category.getCategoryId());
        categoryForm.setCategoryName(category.getCategoryName());

        model.addAttribute("categoryForm", categoryForm);
        return "admin/category/form";
    }

    // 수정 처리
    @PostMapping("/edit/{categoryId}")
    public String edit(@PathVariable("categoryId") Long categoryId,
                       @Valid @ModelAttribute("categoryForm") CategoryForm categoryForm,
                       BindingResult bindingResult,
                       HttpSession session) {
        checkAdmin(session);

        if (bindingResult.hasErrors()) {
            return "admin/category/form";
        }

        categoryForm.setCategoryId(categoryId);
        categoryService.updateCategory(categoryForm);
        return "redirect:/admin/categories";
    }

    // 삭제 처리
    @PostMapping("/delete/{categoryId}")
    public String delete(@PathVariable("categoryId") Long categoryId,
                         HttpSession session) {
        checkAdmin(session);
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories";
    }

    // 관리자 권한 체크
    private void checkAdmin(HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null || !"ROLE_ADMIN".equals(loginUser.getRole())) {
            throw new RuntimeException("관리자만 접근할 수 있습니다.");
        }
    }
}