package br.com.zinid.returnal.application.domain.author;

import java.time.OffsetDateTime;

public class Author {

    private String email;
    private String name;
    private String description;
    private OffsetDateTime registrationDate;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Author(String email, String name, String description) {
        this.email = email;
        this.name = name;
        this.description = description;
        this.registrationDate = OffsetDateTime.now();
    }

    public Author(String email, String name, String description, OffsetDateTime registrationDate) {
        this.email = email;
        this.name = name;
        this.description = description;
        this.registrationDate = registrationDate;
    }
}
