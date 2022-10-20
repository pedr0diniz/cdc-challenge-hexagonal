package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.adapter.author.output.AuthorResponse;
import br.com.zinid.returnal.adapter.category.output.CategoryResponse;
import br.com.zinid.returnal.application.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponse {
    private String title;
    private String summary;
    private String index;
    private BigDecimal price;
    private Integer numberOfPages;
    private String ISBN;
    private LocalDate airingDate;

    @JsonProperty("category")
    private CategoryResponse categoryResponse;

    @JsonProperty("author")
    private AuthorResponse authorResponse;

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

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public AuthorResponse getAuthorResponse() {
        return authorResponse;
    }

    public BookResponse(String title, String summary, String index, BigDecimal price, Integer numberOfPages,
                        String ISBN, LocalDate airingDate, CategoryResponse categoryResponse, AuthorResponse authorResponse) {
        this.title = title;
        this.summary = summary;
        this.index = index;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
        this.airingDate = airingDate;
        this.categoryResponse = categoryResponse;
        this.authorResponse = authorResponse;
    }

    public static BookResponse convertFromDomain(Book book) {
        return new BookResponse(
                book.getTitle(),
                book.getSummary(),
                book.getIndex(),
                book.getPrice(),
                book.getNumberOfPages(),
                book.getISBN(),
                book.getAiringDate(),
                CategoryResponse.convertFromDomain(book.getCategory()),
                AuthorResponse.convertFromDomain(book.getAuthor()));
    }
}
