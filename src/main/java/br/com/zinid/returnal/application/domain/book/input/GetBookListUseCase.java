package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.GetBookListOutputPort;

import java.util.List;

public class GetBookListUseCase implements GetBookListInputPort {

    private final GetBookListOutputPort getBookListService;
    public GetBookListUseCase(GetBookListOutputPort getBookListService) {
        this.getBookListService = getBookListService;
    }


    @Override
    public List<Book> execute() {
        return getBookListService.get();
    }
}
