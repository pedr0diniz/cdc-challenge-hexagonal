package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetBookDetailsAdapterTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private GetBookDetailsAdapter getBookDetailsAdapter;

    @Test
    void returnsMappedDomainBookWhenFound() {
        // given
        BookEntity entity = new BookEntity(new Book("Clean Code", "Summary", "Index",
                BigDecimal.valueOf(59.90), 431, "ISBN-001",
                LocalDate.now().plusDays(30), 1L, 2L));
        given(bookRepository.findById(1L)).willReturn(Optional.of(entity));

        // when
        Optional<Book> result = getBookDetailsAdapter.get(1L);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getTitle()).isEqualTo("Clean Code");
        assertThat(result.get().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(59.90));
    }

    @Test
    void returnsEmptyWhenNotFound() {
        // given
        given(bookRepository.findById(99L)).willReturn(Optional.empty());

        // when
        Optional<Book> result = getBookDetailsAdapter.get(99L);

        // then
        assertThat(result).isEmpty();
    }
}
