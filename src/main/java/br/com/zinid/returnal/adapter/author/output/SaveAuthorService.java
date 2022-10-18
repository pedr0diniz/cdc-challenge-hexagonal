package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.AuthorOutputPort;
import org.springframework.stereotype.Service;

@Service
public class SaveAuthorService implements AuthorOutputPort {

    private AuthorRepository authorRepository;
    public SaveAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        AuthorEntity authorEntity = AuthorEntity.convertFromDomain(author);
        authorRepository.save(authorEntity);
    }
}
