package br.com.zinid.returnal.application.domain.book;

public class CreateBookUseCase implements BookInputPort{

    private final BookOutputPort saveBookService;

    public CreateBookUseCase(BookOutputPort saveBookService) {
        this.saveBookService = saveBookService;
    }


    @Override
    public void create(Book book) {
        saveBookService.save(book);
    }
}
