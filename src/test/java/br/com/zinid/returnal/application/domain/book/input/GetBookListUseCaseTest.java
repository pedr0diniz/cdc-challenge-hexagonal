package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.GetBookListOutputPort;
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
class GetBookListUseCaseTest {

    @Mock
    private GetBookListOutputPort getBookListOutputPort;
    @InjectMocks
    private GetBookListUseCase getBookListUseCase;

    @Test
    void returnsAllBooksFromOutputPort() {
        // given
        Book book = new Book("Title", "Summary", "Index", BigDecimal.valueOf(29.99),
                200, "ISBN-123", LocalDate.now().plusDays(1), 1L, 1L);
        given(getBookListOutputPort.get()).willReturn(List.of(book));

        // when
        List<Book> result = getBookListUseCase.execute();

        // then
        assertThat(result).containsExactly(book);
    }

    @Test
    void returnsEmptyListWhenNoBooksExist() {
        // given
        given(getBookListOutputPort.get()).willReturn(List.of());

        // when
        List<Book> result = getBookListUseCase.execute();

        // then
        assertThat(result).isEmpty();
    }
}
