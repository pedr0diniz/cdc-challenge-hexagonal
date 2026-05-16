package br.com.zinid.returnal.adapter.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookRequestTest {

    private static final LocalDate AIRING_DATE = LocalDate.now().plusDays(30);

    private BookRequest buildRequest() {
        return new BookRequest("Clean Code", "A summary", "Index",
                BigDecimal.valueOf(59.90), 431, "ISBN-001", AIRING_DATE, 1L, 2L);
    }

    @Test
    void toDomainCreatesBookWithAllFields() {
        // given
        BookRequest request = buildRequest();

        // when
        Book domain = request.toDomain();

        // then
        assertThat(domain.getTitle()).isEqualTo("Clean Code");
        assertThat(domain.getSummary()).isEqualTo("A summary");
        assertThat(domain.getIndex()).isEqualTo("Index");
        assertThat(domain.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
        assertThat(domain.getNumberOfPages()).isEqualTo(431);
        assertThat(domain.getISBN()).isEqualTo("ISBN-001");
        assertThat(domain.getAiringDate()).isEqualTo(AIRING_DATE);
        assertThat(domain.getCategoryId()).isEqualTo(1L);
        assertThat(domain.getAuthorId()).isEqualTo(2L);
    }

    @Test
    void gettersReturnFieldValues() {
        // given
        BookRequest request = buildRequest();

        // when / then
        assertThat(request.getTitle()).isEqualTo("Clean Code");
        assertThat(request.getSummary()).isEqualTo("A summary");
        assertThat(request.getIndex()).isEqualTo("Index");
        assertThat(request.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
        assertThat(request.getNumberOfPages()).isEqualTo(431);
        assertThat(request.getISBN()).isEqualTo("ISBN-001");
        assertThat(request.getAiringDate()).isEqualTo(AIRING_DATE);
        assertThat(request.getCategoryId()).isEqualTo(1L);
        assertThat(request.getAuthorId()).isEqualTo(2L);
    }
}
