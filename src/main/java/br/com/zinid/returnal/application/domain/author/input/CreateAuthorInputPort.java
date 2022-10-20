package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;

public interface CreateAuthorInputPort {

    void create(Author author);

}
