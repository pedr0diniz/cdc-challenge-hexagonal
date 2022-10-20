package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.GetAuthorByIdOutputPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAuthorByIdAdapter implements GetAuthorByIdOutputPort {

    private final AuthorRepository authorRepository;
    public GetAuthorByIdAdapter(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> getAuthor(Long id) {
        Optional<AuthorEntity> possibleAuthor = authorRepository.findById(id);
        return possibleAuthor.map(AuthorEntity::toDomain);
        //If a value is present, returns an Optional describing (as if by ofNullable) the result of applying the given
        // mapping function to the value, otherwise returns an empty Optional.

        // Equivalent code below:
//        if (possibleAuthor.isPresent()) {
//            return Optional.of(possibleAuthor.get().toDomain());
//        }
//
//        return Optional.empty();

    }
}
