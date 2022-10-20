package br.com.zinid.returnal.adapter.book.input;

import br.com.zinid.returnal.adapter.book.output.BookResponse;
import br.com.zinid.returnal.application.domain.author.input.GetAuthorByIdInputPort;
import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.input.CreateBookInputPort;
import br.com.zinid.returnal.application.domain.book.input.GetBookListInputPort;
import br.com.zinid.returnal.application.domain.category.input.GetCategoryByIdInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    private final CreateBookInputPort createBookUseCase;
    private final GetBookListInputPort getBookListUseCase;
    private final GetCategoryByIdInputPort getCategoryByIdUseCase;
    private final GetAuthorByIdInputPort getAuthorByIdUseCase;
    public BookController(CreateBookInputPort createBookUseCase,
                          GetBookListInputPort getBookListUseCase, GetCategoryByIdInputPort getCategoryByIdUseCase,
                          GetAuthorByIdInputPort getAuthorByIdUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.getBookListUseCase = getBookListUseCase;
        this.getCategoryByIdUseCase = getCategoryByIdUseCase;
        this.getAuthorByIdUseCase = getAuthorByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest bookRequest) {
        Book book = bookRequest.toDomain();
        System.out.println(book.toString());
        createBookUseCase.create(book);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> listBooks() {
        return ResponseEntity.ok(getBookListUseCase.execute()
                .stream().map(BookResponse::convertFromDomain).collect(Collectors.toList()));
    }
}
