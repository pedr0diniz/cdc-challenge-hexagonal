package br.com.zinid.returnal.application.domain.author;

import java.util.Optional;

public class GetAuthorByIdUseCase implements GetAuthorByIdInputPort {

    private final GetAuthorByIdOutputPort getAuthorByIdOutputPort;

    public GetAuthorByIdUseCase(GetAuthorByIdOutputPort getAuthorByIdOutputPort) {
        this.getAuthorByIdOutputPort = getAuthorByIdOutputPort;
    }

    @Override
    public Optional<Author> execute(Long id) {
        return getAuthorByIdOutputPort.getAuthor(id);
    }
}
