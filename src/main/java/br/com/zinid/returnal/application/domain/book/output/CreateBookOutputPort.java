package br.com.zinid.returnal.application.domain.book.output;

import br.com.zinid.returnal.application.domain.book.Book;

public interface CreateBookOutputPort {

    void create(Book book);

}
