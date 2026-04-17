package com.pknu26.book_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu26.book_mng.dto.BookForm;
import com.pknu26.book_mng.entity.Book;
import com.pknu26.book_mng.service.BookService;

import jakarta.validation.Valid;

@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // 도서 목록
    @GetMapping("/list")
    public String showList(Model model) {
        List<Book> bookList = this.bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "book_list";
    }

    // 도서 상세
    @GetMapping("/detail/{bookId}")
    public String showDetail(Model model, @PathVariable("bookId") Long bookId) {
        Book book = this.bookService.getBookOne(bookId);
        model.addAttribute("book", book);
        return "book_detail";
    }

    // 도서 등록 화면
    @GetMapping("/create")
    public String showCreate(Model model, BookForm bookForm) {
        model.addAttribute("mode", "create");
        return "book_create";
    }

    // 도서 등록 처리
    @PostMapping("/create")
    public String createBook(@Valid BookForm bookForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "create");
            return "book_create";
        }

        boolean result = this.bookService.setBookOne(bookForm);

        if (!result) {
            model.addAttribute("mode", "create");
            model.addAttribute("errorMessage", "ISBN이 중복되었거나 저장 중 오류가 발생했습니다.");
            return "book_create";
        }

        return "redirect:/book/list";
    }

    // 도서 수정 화면
    @GetMapping("/modify/{bookId}")
    public String showModify(Model model, BookForm bookForm, @PathVariable("bookId") Long bookId) {
        Book book = this.bookService.getBookOne(bookId);

        bookForm.setTitle(book.getTitle());
        bookForm.setAuthor(book.getAuthor());
        bookForm.setPublisher(book.getPublisher());
        bookForm.setIsbn(book.getIsbn());
        bookForm.setCategory(book.getCategory());
        bookForm.setPrice(book.getPrice());
        bookForm.setStock(book.getStock());
        bookForm.setPublishedDate(book.getPublishedDate());
        bookForm.setDescription(book.getDescription());

        model.addAttribute("mode", "modify");
        model.addAttribute("bookId", book.getBookId());

        return "book_create";
    }

    // 도서 수정 처리
    @PostMapping("/modify/{bookId}")
    public String modifyBook(@Valid BookForm bookForm, BindingResult bindingResult,
                             @PathVariable("bookId") Long bookId, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "modify");
            model.addAttribute("bookId", bookId);
            return "book_create";
        }

        Book book = this.bookService.getBookOne(bookId);
        boolean result = this.bookService.putBookOne(book, bookForm);

        if (!result) {
            model.addAttribute("mode", "modify");
            model.addAttribute("bookId", bookId);
            model.addAttribute("errorMessage", "ISBN이 중복되었거나 수정 중 오류가 발생했습니다.");
            return "book_create";
        }

        return "redirect:/book/list";
    }

    // 도서 삭제
    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId) {
        Book book = this.bookService.getBookOne(bookId);
        this.bookService.deleteBookOne(book);
        return "redirect:/book/list";
    }
}