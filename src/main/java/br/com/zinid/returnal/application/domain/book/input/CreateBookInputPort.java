package br.com.zinid.returnal.application.domain.book.input;

import br.com.zinid.returnal.application.domain.book.Book;

public interface CreateBookInputPort {

    void create(Book book);

}
