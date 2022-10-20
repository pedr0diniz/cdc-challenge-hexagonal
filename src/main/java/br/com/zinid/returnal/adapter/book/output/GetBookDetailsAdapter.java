package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.GetBookDetailsOutputPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetBookDetailsAdapter implements GetBookDetailsOutputPort {

    private final BookRepository bookRepository;
    public GetBookDetailsAdapter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id).map(BookEntity::toDomain);
    }
}
