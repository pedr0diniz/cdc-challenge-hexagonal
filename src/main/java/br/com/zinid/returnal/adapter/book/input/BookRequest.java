package br.com.zinid.returnal.adapter.book.input;

import br.com.zinid.returnal.adapter.author.output.AuthorEntity;
import br.com.zinid.returnal.adapter.book.output.BookEntity;
import br.com.zinid.returnal.adapter.category.output.CategoryEntity;
import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.config.validation.IdMustExist;
import br.com.zinid.returnal.config.validation.UniqueField;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {

    @NotBlank
    @UniqueField(fieldName = "title", entityClass = BookEntity.class)
    private String title;

    @NotBlank @Size(max = 500)
    private String summary;

    private String index;

    @NotNull
    @Min(value = 20)
    private BigDecimal price;

    @NotNull @Min(value = 100)
    private Integer numberOfPages;

    @NotBlank
    private String ISBN;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate airingDate;

    @NotNull
    @IdMustExist(entityClass = CategoryEntity.class)
    private Long categoryId;

    @NotNull
    @IdMustExist(entityClass = AuthorEntity.class)
    private Long authorId;

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getIndex() {
        return index;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getISBN() {
        return ISBN;
    }

    public LocalDate getAiringDate() {
        return airingDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public BookRequest(String title, String summary, String index, BigDecimal price, Integer numberOfPages, String ISBN,
                       LocalDate airingDate, Long categoryId, Long authorId) {
        this.title = title;
        this.summary = summary;
        this.index = index;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
        this.airingDate = airingDate;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book toDomain() {
        return new Book(
                title = title,
                summary = summary,
                index = index,
                price = price,
                numberOfPages = numberOfPages,
                ISBN = ISBN,
                airingDate = airingDate,
                categoryId = categoryId,
                authorId = authorId
        );
    }

}
