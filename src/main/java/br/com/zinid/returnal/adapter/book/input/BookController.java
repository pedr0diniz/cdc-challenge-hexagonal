package br.com.zinid.returnal.adapter.book.input;

import br.com.zinid.returnal.application.domain.author.GetAuthorByIdInputPort;
import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.BookInputPort;
import br.com.zinid.returnal.application.domain.category.GetCategoryByIdInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookInputPort createBookUseCase;
    private final GetCategoryByIdInputPort getCategoryByIdUseCase;
    private final GetAuthorByIdInputPort getAuthorByIdUseCase;
    public BookController(BookInputPort createBookUseCase,
                          GetCategoryByIdInputPort getCategoryByIdUseCase,
                          GetAuthorByIdInputPort getAuthorByIdUseCase) {
        this.createBookUseCase = createBookUseCase;
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

}
