package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.GetBookDetailsOutputPort;
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
class GetBookDetailsUseCaseTest {

    @Mock
    private GetBookDetailsOutputPort getBookDetailsOutputPort;
    @InjectMocks
    private GetBookDetailsUseCase getBookDetailsUseCase;

    @Test
    void returnsBookWhenFound() {
        // given
        Book book = new Book("Title", "Summary", "Index", BigDecimal.valueOf(29.99),
                200, "ISBN-123", LocalDate.now().plusDays(1), 1L, 1L);
        given(getBookDetailsOutputPort.get(1L)).willReturn(Optional.of(book));

        // when
        Optional<Book> result = getBookDetailsUseCase.execute(1L);

        // then
        assertThat(result).contains(book);
    }

    @Test
    void returnsEmptyWhenNotFound() {
        // given
        given(getBookDetailsOutputPort.get(99L)).willReturn(Optional.empty());

        // when
        Optional<Book> result = getBookDetailsUseCase.execute(99L);

        // then
        assertThat(result).isEmpty();
    }
}
