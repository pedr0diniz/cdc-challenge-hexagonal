package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.adapter.author.output.AuthorEntity;
import br.com.zinid.returnal.adapter.category.output.CategoryEntity;
import br.com.zinid.returnal.application.domain.book.Book;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "book")
public class BookEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;
    private String index;
    private BigDecimal price;
    private Integer numberOfPages;
    private String ISBN;
    private LocalDate airingDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;

    @Deprecated
    public BookEntity() {
    }

    public BookEntity(Book book) {
        this.title = book.getTitle();
        this.summary = book.getSummary();
        this.index = book.getIndex();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.ISBN = book.getISBN();
        this.airingDate = book.getAiringDate();
        this.categoryEntity = new CategoryEntity(book.getCategoryId());
        this.authorEntity = new AuthorEntity(book.getAuthorId());
    }

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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public Book toDomain() {
        return new Book(
                title,
                summary,
                index,
                price,
                numberOfPages,
                ISBN,
                airingDate,
                categoryEntity.toDomain(),
                authorEntity.toDomain()
        );
    }

}
