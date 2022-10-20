package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;

import java.util.List;

public interface GetBookListInputPort {

    List<Book> execute();

}
