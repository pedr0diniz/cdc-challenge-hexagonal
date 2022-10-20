package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.adapter.author.output.AuthorResponse;
import br.com.zinid.returnal.application.domain.book.Book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDetails {

    private String title;
    private BigDecimal price;
    private String summary;
    private String index;
    private AuthorResponse author;
    private BookData bookData;

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSummary() {
        return summary;
    }

    public String getIndex() {
        return index;
    }

    public AuthorResponse getAuthor() {
        return author;
    }

    public BookData getBookData() {
        return bookData;
    }

    public BookDetails(Book book) {
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.summary = book.getSummary();
        this.index = book.getIndex();
        this.author = AuthorResponse.convertFromDomain(book.getAuthor());
        this.bookData = new BookData(book.getNumberOfPages(), book.getISBN(), book.getAiringDate());
    }

    public class BookData {
        private Integer numberOfPages;
        private String ISBN;
        private LocalDate airingDate;

        public Integer getNumberOfPages() {
            return numberOfPages;
        }

        public String getISBN() {
            return ISBN;
        }

        public LocalDate getAiringDate() {
            return airingDate;
        }

        public BookData(Integer numberOfPages, String ISBN, LocalDate airingDate) {
            this.numberOfPages = numberOfPages;
            this.ISBN = ISBN;
            this.airingDate = airingDate;
        }
    }

}
