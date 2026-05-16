package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.adapter.author.output.AuthorResponse;
import br.com.zinid.returnal.adapter.category.output.CategoryResponse;
import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookResponseTest {

    private static final LocalDate AIRING_DATE = LocalDate.now().plusDays(30);

    private Book bookWithObjects() {
        return new Book("Clean Code", "A summary", "Index", BigDecimal.valueOf(59.90),
                431, "ISBN-001", AIRING_DATE,
                new Category("Technology"),
                new Author("author@test.com", "Robert Martin", "Uncle Bob"));
    }

    @Test
    void convertFromDomainMapsAllFields() {
        // given
        Book book = bookWithObjects();

        // when
        BookResponse response = BookResponse.convertFromDomain(book);

        // then
        assertThat(response.getTitle()).isEqualTo("Clean Code");
        assertThat(response.getSummary()).isEqualTo("A summary");
        assertThat(response.getIndex()).isEqualTo("Index");
        assertThat(response.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
        assertThat(response.getNumberOfPages()).isEqualTo(431);
        assertThat(response.getISBN()).isEqualTo("ISBN-001");
        assertThat(response.getAiringDate()).isEqualTo(AIRING_DATE);
        assertThat(response.getCategoryResponse().getName()).isEqualTo("Technology");
        assertThat(response.getAuthorResponse().getName()).isEqualTo("Robert Martin");
    }

    @Test
    void constructorSetsAllFields() {
        // given
        CategoryResponse category = new CategoryResponse("Fiction");
        AuthorResponse author = new AuthorResponse("e@e.com", "Name", "Desc");

        // when
        BookResponse response = new BookResponse("Title", "Summary", "Index",
                BigDecimal.valueOf(20), 200, "ISBN", AIRING_DATE, category, author);

        // then
        assertThat(response.getTitle()).isEqualTo("Title");
        assertThat(response.getSummary()).isEqualTo("Summary");
        assertThat(response.getIndex()).isEqualTo("Index");
    }
}
