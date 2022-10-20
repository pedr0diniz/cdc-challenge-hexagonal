package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;

import java.util.Optional;

public interface GetBookDetailsInputPort {

    Optional<Book> execute(Long id);

}
