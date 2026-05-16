package br.com.zinid.returnal.adapter.book.input;

import br.com.zinid.returnal.adapter.book.output.BookDetails;
import br.com.zinid.returnal.adapter.book.output.BookResponse;
import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.input.GetAuthorByIdInputPort;
import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.input.CreateBookInputPort;
import br.com.zinid.returnal.application.domain.book.input.GetBookDetailsInputPort;
import br.com.zinid.returnal.application.domain.book.input.GetBookListInputPort;
import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.input.GetCategoryByIdInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private CreateBookInputPort createBookUseCase;
    @Mock
    private GetBookListInputPort getBookListUseCase;
    @Mock
    private GetBookDetailsInputPort getBookDetailsUseCase;
    @Mock
    private GetCategoryByIdInputPort getCategoryByIdUseCase;
    @Mock
    private GetAuthorByIdInputPort getAuthorByIdUseCase;
    @InjectMocks
    private BookController bookController;

    private Book bookWithObjects() {
        return new Book("Clean Code", "Summary", "Index", BigDecimal.valueOf(59.90),
                431, "ISBN-001", LocalDate.now().plusDays(30),
                new Category("Technology"),
                new Author("author@test.com", "Robert Martin", "Uncle Bob"));
    }

    @Test
    void createBookReturnsOkAndDelegatesToUseCase() {
        // given
        BookRequest request = new BookRequest("Clean Code", "Summary", "Index",
                BigDecimal.valueOf(59.90), 431, "ISBN-001",
                LocalDate.now().plusDays(30), 1L, 2L);

        // when
        ResponseEntity<?> response = bookController.createBook(request);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        then(createBookUseCase).should().execute(any(Book.class));
    }

    @Test
    void listBooksReturnsOkWithMappedResponses() {
        // given
        given(getBookListUseCase.execute()).willReturn(List.of(bookWithObjects()));

        // when
        ResponseEntity<List<BookResponse>> response = bookController.listBooks();

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0).getTitle()).isEqualTo("Clean Code");
    }

    @Test
    void listBooksReturnsEmptyListWhenNoBooks() {
        // given
        given(getBookListUseCase.execute()).willReturn(List.of());

        // when
        ResponseEntity<List<BookResponse>> response = bookController.listBooks();

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    void getBookDetailsReturnsOkWithDetailsWhenFound() {
        // given
        given(getBookDetailsUseCase.execute(1L)).willReturn(Optional.of(bookWithObjects()));

        // when
        ResponseEntity<?> response = bookController.getBookDetails(1L);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isInstanceOf(BookDetails.class);
    }

    @Test
    void getBookDetailsReturnsNotFoundWhenBookDoesNotExist() {
        // given
        given(getBookDetailsUseCase.execute(99L)).willReturn(Optional.empty());

        // when
        ResponseEntity<?> response = bookController.getBookDetails(99L);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }
}
