package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.CreateAuthorOutputPort;

public class CreateAuthorUseCase implements CreateAuthorInputPort {

    private final CreateAuthorOutputPort createAuthorService;
    public CreateAuthorUseCase(CreateAuthorOutputPort createAuthorService) {
        this.createAuthorService = createAuthorService;
    }

    @Override
    public void create(Author author) {
        createAuthorService.save(author);
    }
}
