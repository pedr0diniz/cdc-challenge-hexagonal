package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.GetAuthorByIdOutputPort;

import java.util.Optional;

public class GetAuthorByIdUseCase implements GetAuthorByIdInputPort {

    private final GetAuthorByIdOutputPort getAuthorByIdOutputPort;

    public GetAuthorByIdUseCase(GetAuthorByIdOutputPort getAuthorByIdOutputPort) {
        this.getAuthorByIdOutputPort = getAuthorByIdOutputPort;
    }

    @Override
    public Optional<Author> execute(Long id) {
        return getAuthorByIdOutputPort.get(id);
    }
}
