package br.com.zinid.returnal.application.domain.author.output;

import br.com.zinid.returnal.application.domain.author.Author;

import java.util.Optional;

public interface GetAuthorByIdOutputPort {

    Optional<Author> getAuthor(Long id);

}
