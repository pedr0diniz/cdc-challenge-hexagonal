package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.CreateAuthorOutputPort;

public class CreateAuthorUseCase implements CreateAuthorInputPort {

    private final CreateAuthorOutputPort createAuthorAdapter;
    public CreateAuthorUseCase(CreateAuthorOutputPort createAuthorAdapter) {
        this.createAuthorAdapter = createAuthorAdapter;
    }

    @Override
    public void execute(Author author) {
        createAuthorAdapter.create(author);
    }
}
