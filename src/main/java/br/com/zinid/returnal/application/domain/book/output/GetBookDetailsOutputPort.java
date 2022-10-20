package br.com.zinid.returnal.application.domain.book.output;

import br.com.zinid.returnal.application.domain.book.Book;

import java.util.Optional;

public interface GetBookDetailsOutputPort {

    Optional<Book> get(Long id);

}
