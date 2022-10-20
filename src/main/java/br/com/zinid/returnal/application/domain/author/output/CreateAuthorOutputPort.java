package br.com.zinid.returnal.application.domain.author.output;

import br.com.zinid.returnal.application.domain.author.Author;

public interface CreateAuthorOutputPort {

    void save(Author author);

}
