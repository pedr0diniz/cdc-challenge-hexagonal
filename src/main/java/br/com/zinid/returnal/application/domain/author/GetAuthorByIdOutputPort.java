package br.com.zinid.returnal.application.domain.author;

import java.util.Optional;

public interface GetAuthorByIdOutputPort {

    Optional<Author> getAuthor(Long id);

}
