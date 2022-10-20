package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String description;
    private OffsetDateTime registrationDate;

    // Entity requirement
    @Deprecated
    public AuthorEntity() {
    }

    // For the BookEntity to use while retrieving the id.
    public AuthorEntity(Long id) {
        this.id = id;
    }

    public AuthorEntity(String email, String name, String description, OffsetDateTime registrationDate) {
        this.email = email;
        this.name = name;
        this.description = description;
        this.registrationDate = OffsetDateTime.now();
    }

    public Author toDomain() {
        return new Author(email, name, description, registrationDate);
    }

    public static AuthorEntity convertFromDomain(Author author) {
        return new AuthorEntity(author.getEmail(), author.getName(), author.getDescription(), author.getRegistrationDate());
    }

}
