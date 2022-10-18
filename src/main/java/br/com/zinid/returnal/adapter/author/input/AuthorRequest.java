package br.com.zinid.returnal.adapter.author.input;

import br.com.zinid.returnal.adapter.author.output.AuthorEntity;
import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.validation.UniqueField;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank @Email @UniqueField(fieldName = "email", entityClass = AuthorEntity.class)
    private String email;

    @NotBlank
    private String name;

    @NotBlank @Size(max = 400)
    private String description;

    public Author toDomain() {
        return new Author(
                email = this.email,
                name = this.name,
                description = this.description
        );
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
