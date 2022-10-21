package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.CreateAuthorOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorAdapter implements CreateAuthorOutputPort {

    private final AuthorRepository authorRepository;
    public CreateAuthorAdapter(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(Author author) {
        AuthorEntity authorEntity = AuthorEntity.convertFromDomain(author);
        authorRepository.save(authorEntity);
    }
}
