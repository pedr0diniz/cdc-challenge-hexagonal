package br.com.zinid.returnal.application.domain.book;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {

    private String title;
    private String summary;
    private String index;
    private BigDecimal price;
    private Integer numberOfPages;
    private String ISBN;
    private LocalDate airingDate;
    private Category category;
    private Long categoryId;
    private Author author;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Book(String title, String summary, String index, BigDecimal price, Integer numberOfPages, String ISBN,
                LocalDate airingDate, Category category, Author author) {
        this.title = title;
        this.summary = summary;
        this.index = index;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
        this.airingDate = airingDate;
        this.category = category;
        this.author = author;
    }

    public Book(String title, String summary, String index, BigDecimal price, Integer numberOfPages, String ISBN,
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", index='" + index + '\'' +
                ", price=" + price +
                ", numberOfPages=" + numberOfPages +
                ", ISBN='" + ISBN + '\'' +
                ", airingDate=" + airingDate +
                ", category=" + category +
                ", categoryId=" + categoryId +
                ", author=" + author +
                ", authorId=" + authorId +
                '}';
    }
}
