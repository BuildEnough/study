package com.pknu26.book_mng.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.book_mng.dto.BookForm;
import com.pknu26.book_mng.entity.Book;
import com.pknu26.book_mng.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 도서 전체 조회
    public List<Book> getBookList() {
        return this.bookRepository.findAll();
    }

    // 도서 한 건 조회
    public Book getBookOne(Long bookId) {

        Optional<Book> opBook = this.bookRepository.findById(bookId);

        if (opBook.isPresent()) {
            return opBook.get();
        } else {
            throw new RuntimeException("Book Data not found");
        }
    }

    // 도서 등록
    public boolean setBookOne(BookForm bookForm) {
        try {
            Book book = new Book();
            book.setTitle(bookForm.getTitle());
            book.setAuthor(bookForm.getAuthor());
            book.setPublisher(bookForm.getPublisher());
            book.setIsbn(bookForm.getIsbn());
            book.setCategory(bookForm.getCategory());
            book.setPrice(bookForm.getPrice());
            book.setStock(bookForm.getStock() != null ? bookForm.getStock() : 0);
            book.setPublishedDate(bookForm.getPublishedDate());
            book.setDescription(bookForm.getDescription());
            book.setCreatedAt(LocalDateTime.now());
            book.setUpdatedAt(LocalDateTime.now());

            this.bookRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 도서 수정
    public boolean putBookOne(Book book, BookForm bookForm) {
        try {
            book.setTitle(bookForm.getTitle());
            book.setAuthor(bookForm.getAuthor());
            book.setPublisher(bookForm.getPublisher());
            book.setIsbn(bookForm.getIsbn());
            book.setCategory(bookForm.getCategory());
            book.setPrice(bookForm.getPrice());
            book.setStock(bookForm.getStock());
            book.setPublishedDate(bookForm.getPublishedDate());
            book.setDescription(bookForm.getDescription());
            book.setUpdatedAt(LocalDateTime.now());

            this.bookRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 도서 삭제
    public void deleteBookOne(Book book) {
        this.bookRepository.delete(book);
    }
}