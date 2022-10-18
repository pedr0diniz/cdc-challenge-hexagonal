package br.com.zinid.returnal.adapter.author.input;

import br.com.zinid.returnal.adapter.author.output.SaveAuthorService;
import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.AuthorInputPort;
import br.com.zinid.returnal.application.domain.author.AuthorOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorService implements AuthorInputPort {

    private AuthorOutputPort saveAuthorService;
    public CreateAuthorService(AuthorOutputPort saveAuthorService) {
        this.saveAuthorService = saveAuthorService;
    }

    @Override
    public void create(Author author) {
        saveAuthorService.save(author);
    }
}
