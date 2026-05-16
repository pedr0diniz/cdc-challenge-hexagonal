package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookDetailsTest {

    private static final LocalDate AIRING_DATE = LocalDate.now().plusDays(30);

    @Test
    void constructorFromBookMapsAllFields() {
        // given
        Book book = new Book("Clean Code", "A great summary", "The index",
                BigDecimal.valueOf(59.90), 431, "ISBN-001", AIRING_DATE,
                new Category("Technology"),
                new Author("author@test.com", "Robert Martin", "Uncle Bob"));

        // when
        BookDetails details = new BookDetails(book);

        // then
        assertThat(details.getTitle()).isEqualTo("Clean Code");
        assertThat(details.getSummary()).isEqualTo("A great summary");
        assertThat(details.getIndex()).isEqualTo("The index");
        assertThat(details.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
        assertThat(details.getAuthor().getName()).isEqualTo("Robert Martin");
    }

    @Test
    void bookDataInnerClassHoldsMetadata() {
        // given
        Book book = new Book("Title", "Summary", "Index",
                BigDecimal.valueOf(29.99), 200, "ISBN-XYZ", AIRING_DATE,
                new Category("Fiction"),
                new Author("a@a.com", "Author", "Desc"));

        // when
        BookDetails details = new BookDetails(book);

        // then
        assertThat(details.getBookData().getNumberOfPages()).isEqualTo(200);
        assertThat(details.getBookData().getISBN()).isEqualTo("ISBN-XYZ");
        assertThat(details.getBookData().getAiringDate()).isEqualTo(AIRING_DATE);
    }
}
