package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.CreateBookOutputPort;

public class CreateBookUseCase implements CreateBookInputPort {

    private final CreateBookOutputPort createBookAdapter;

    public CreateBookUseCase(CreateBookOutputPort createBookAdapter) {
        this.createBookAdapter = createBookAdapter;
    }


    @Override
    public void execute(Book book) {
        createBookAdapter.create(book);
    }
}
