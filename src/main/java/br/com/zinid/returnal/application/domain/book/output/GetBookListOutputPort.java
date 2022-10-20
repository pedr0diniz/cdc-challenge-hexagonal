package br.com.zinid.returnal.application.domain.book.output;

import br.com.zinid.returnal.application.domain.book.Book;

import java.util.List;

public interface GetBookListOutputPort {

    List<Book> get();

}
