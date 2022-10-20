package br.com.zinid.returnal.adapter.book.output;

import br.com.zinid.returnal.application.domain.book.Book;
import br.com.zinid.returnal.application.domain.book.output.GetBookListOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetBookListAdapter implements GetBookListOutputPort {

    private final BookRepository bookRepository;
    public GetBookListAdapter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> get() {
        List<BookEntity> books = bookRepository.findAll();
        return books.stream().map(BookEntity::toDomain).collect(Collectors.toList());
    }
}
