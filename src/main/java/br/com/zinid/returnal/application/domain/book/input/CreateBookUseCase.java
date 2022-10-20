package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.CreateBookOutputPort;

public class CreateBookUseCase implements CreateBookInputPort {

    private final CreateBookOutputPort createBookService;

    public CreateBookUseCase(CreateBookOutputPort createBookService) {
        this.createBookService = createBookService;
    }


    @Override
    public void create(Book book) {
        createBookService.save(book);
    }
}
