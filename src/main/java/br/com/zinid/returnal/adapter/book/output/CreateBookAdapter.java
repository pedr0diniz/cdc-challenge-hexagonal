package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.CreateBookOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateBookAdapter implements CreateBookOutputPort {

    private final BookRepository bookRepository;

    public CreateBookAdapter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        BookEntity bookEntity = new BookEntity(book);
        bookRepository.save(bookEntity);
    }
}
