package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;

import java.util.Optional;

public interface GetAuthorByIdInputPort {

    Optional<Author> execute(Long id);

}
