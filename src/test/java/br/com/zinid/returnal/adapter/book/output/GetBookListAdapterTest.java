package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetBookListAdapterTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private GetBookListAdapter getBookListAdapter;

    @Test
    void returnsMappedDomainBooksFromRepository() {
        // given
        BookEntity entity = new BookEntity(new Book("Clean Code", "Summary", "Index",
                BigDecimal.valueOf(59.90), 431, "ISBN-001",
                LocalDate.now().plusDays(30), 1L, 2L));
        given(bookRepository.findAll()).willReturn(List.of(entity));

        // when
        List<Book> result = getBookListAdapter.get();

        // then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Clean Code");
    }

    @Test
    void returnsEmptyListWhenRepositoryIsEmpty() {
        // given
        given(bookRepository.findAll()).willReturn(List.of());

        // when
        List<Book> result = getBookListAdapter.get();

        // then
        assertThat(result).isEmpty();
    }
}
