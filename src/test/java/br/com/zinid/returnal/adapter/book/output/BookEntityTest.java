package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookEntityTest {

    private static final LocalDate AIRING_DATE = LocalDate.now().plusDays(30);

    private Book bookWithIds() {
        return new Book("Clean Code", "A summary", "Table of contents",
                BigDecimal.valueOf(59.90), 431, "978-0132350884", AIRING_DATE, 1L, 2L);
    }

    @Test
    void constructorFromBookSetsAllScalarFields() {
        // given
        Book book = bookWithIds();

        // when
        BookEntity entity = new BookEntity(book);

        // then
        assertThat(entity.getTitle()).isEqualTo("Clean Code");
        assertThat(entity.getSummary()).isEqualTo("A summary");
        assertThat(entity.getIndex()).isEqualTo("Table of contents");
        assertThat(entity.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
        assertThat(entity.getNumberOfPages()).isEqualTo(431);
        assertThat(entity.getISBN()).isEqualTo("978-0132350884");
        assertThat(entity.getAiringDate()).isEqualTo(AIRING_DATE);
    }

    @Test
    void toDomainConvertsCategoryAndAuthorFromIdOnlyEntities() {
        // given
        BookEntity entity = new BookEntity(bookWithIds());

        // when
        Book domain = entity.toDomain();

        // then — category/author were created from IDs, so names are null
        assertThat(domain.getTitle()).isEqualTo("Clean Code");
        assertThat(domain.getCategory()).isNotNull();
        assertThat(domain.getAuthor()).isNotNull();
    }

    @Test
    void toResponseConvertsToBookResponse() {
        // given
        BookEntity entity = new BookEntity(bookWithIds());

        // when
        BookResponse response = entity.toResponse();

        // then
        assertThat(response.getTitle()).isEqualTo("Clean Code");
        assertThat(response.getSummary()).isEqualTo("A summary");
        assertThat(response.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
        assertThat(response.getNumberOfPages()).isEqualTo(431);
        assertThat(response.getISBN()).isEqualTo("978-0132350884");
        assertThat(response.getAiringDate()).isEqualTo(AIRING_DATE);
    }

    @Test
    void getCategoryAndAuthorEntityReturnSetEntities() {
        // given
        BookEntity entity = new BookEntity(bookWithIds());

        // when / then
        assertThat(entity.getCategoryEntity()).isNotNull();
        assertThat(entity.getAuthorEntity()).isNotNull();
    }
}
