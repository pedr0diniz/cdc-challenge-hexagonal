package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.CreateBookOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateBookUseCaseTest {

    @Mock
    private CreateBookOutputPort createBookOutputPort;
    @InjectMocks
    private CreateBookUseCase createBookUseCase;

    @Test
    void delegatesBookCreationToOutputPort() {
        // given
        Book book = new Book("Title", "Summary", "Index", BigDecimal.valueOf(29.99),
                200, "ISBN-123", LocalDate.now().plusDays(1), 1L, 1L);

        // when
        createBookUseCase.execute(book);

        // then
        then(createBookOutputPort).should().create(book);
    }
}
