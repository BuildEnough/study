package com.pknu26.book_mng.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_book")
    @SequenceGenerator(name = "seq_book", sequenceName = "SEQ_BOOK", allocationSize = 1)
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "TITLE", length = 300, nullable = false)
    private String title;

    @Column(name = "AUTHOR", length = 200)
    private String author;

    @Column(name = "PUBLISHER", length = 200)
    private String publisher;

    @Column(name = "ISBN", length = 20, unique = true)
    private String isbn;

    @Column(name = "CATEGORY", length = 100)
    private String category;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "STOCK")
    private Integer stock;

    @Column(name = "PUBLISHED_DATE")
    private LocalDate publishedDate;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}