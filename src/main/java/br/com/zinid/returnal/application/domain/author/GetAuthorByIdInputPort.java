package br.com.zinid.returnal.application.domain.author;

import java.util.Optional;

public interface GetAuthorByIdInputPort {

    Optional<Author> execute(Long id);

}
