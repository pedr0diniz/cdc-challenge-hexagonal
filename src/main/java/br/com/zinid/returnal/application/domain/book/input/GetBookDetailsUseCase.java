package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.GetBookDetailsOutputPort;

import java.util.Optional;

public class GetBookDetailsUseCase implements GetBookDetailsInputPort {

    private final GetBookDetailsOutputPort getBookDetailsAdapter;

    public GetBookDetailsUseCase(GetBookDetailsOutputPort getBookDetailsOutputPort) {
        this.getBookDetailsAdapter = getBookDetailsOutputPort;
    }

    @Override
    public Optional<Book> execute(Long id) {
        return getBookDetailsAdapter.get(id);
    }
}
