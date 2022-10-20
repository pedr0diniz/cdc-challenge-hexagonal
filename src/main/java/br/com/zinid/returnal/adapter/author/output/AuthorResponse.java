package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;

public class AuthorResponse {

    private String name;
    private String description;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AuthorResponse(String email, String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static AuthorResponse convertFromDomain(Author author) {
        return new AuthorResponse(author.getEmail(), author.getName(), author.getDescription());
    }
}
