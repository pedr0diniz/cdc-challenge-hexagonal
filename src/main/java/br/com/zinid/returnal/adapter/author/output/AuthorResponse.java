package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;

public class AuthorResponse {

    private String email;
    private String name;
    private String description;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AuthorResponse(String email, String name, String description) {
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public static AuthorResponse convertFromDomain(Author author) {
        return new AuthorResponse(author.getEmail(), author.getName(), author.getDescription());
    }
}
