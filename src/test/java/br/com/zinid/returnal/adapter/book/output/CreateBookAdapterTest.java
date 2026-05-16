package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateBookAdapterTest {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private CreateBookAdapter createBookAdapter;

    @Test
    void convertsBookToEntityAndSavesIt() {
        // given
        Book book = new Book("Clean Code", "Summary", "Index", BigDecimal.valueOf(59.90),
                431, "ISBN-001", LocalDate.now().plusDays(30), 1L, 2L);
        ArgumentCaptor<BookEntity> captor = ArgumentCaptor.forClass(BookEntity.class);

        // when
        createBookAdapter.create(book);

        // then
        then(bookRepository).should().save(captor.capture());
        assertThat(captor.getValue().getTitle()).isEqualTo("Clean Code");
    }
}
