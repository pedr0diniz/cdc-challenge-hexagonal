package br.com.zinid.returnal.application.domain.author;

public class CreateAuthorUseCase implements AuthorInputPort {

    private final AuthorOutputPort saveAuthorService;
    public CreateAuthorUseCase(AuthorOutputPort saveAuthorService) {
        this.saveAuthorService = saveAuthorService;
    }

    @Override
    public void create(Author author) {
        saveAuthorService.save(author);
    }
}
