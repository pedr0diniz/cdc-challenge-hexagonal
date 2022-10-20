package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.BookOutputPort;
import org.springframework.stereotype.Service;

@Service
public class SaveBookService implements BookOutputPort {

    private final BookRepository bookRepository;

    public SaveBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        BookEntity bookEntity = new BookEntity(book);
        bookRepository.save(bookEntity);
    }
}
