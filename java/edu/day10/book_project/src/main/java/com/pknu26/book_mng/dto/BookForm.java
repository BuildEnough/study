package com.pknu26.book_mng.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    @Size(max = 300)
    @NotBlank(message = "제목을 작성하세요")
    private String title;

    @Size(max = 200)
    private String author;

    @Size(max = 200)
    private String publisher;

    @Size(max = 20)
    private String isbn;

    @Size(max = 100)
    private String category;

    @Min(value = 0, message = "가격은 0 이상이어야 합니다")
    private Integer price;

    @Min(value = 0, message = "재고는 0 이상이어야 합니다")
    private Integer stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;

    private String description;
}