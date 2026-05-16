package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorResponseTest {

    @Test
    void convertFromDomainMapsNameAndDescription() {
        // given
        Author author = new Author("email@test.com", "Author Name", "Author Description");

        // when
        AuthorResponse response = AuthorResponse.convertFromDomain(author);

        // then
        assertThat(response.getName()).isEqualTo("Author Name");
        assertThat(response.getDescription()).isEqualTo("Author Description");
    }

    @Test
    void constructorWithEmailNameDescriptionExposesNameAndDescription() {
        // given / when
        AuthorResponse response = new AuthorResponse("email@test.com", "Name", "Desc");

        // then
        assertThat(response.getName()).isEqualTo("Name");
        assertThat(response.getDescription()).isEqualTo("Desc");
    }

    @Test
    void authorWithRegistrationDateIsConvertedCorrectly() {
        // given
        Author author = new Author("e@e.com", "Name", "Desc", OffsetDateTime.now());

        // when
        AuthorResponse response = AuthorResponse.convertFromDomain(author);

        // then
        assertThat(response.getName()).isEqualTo("Name");
    }
}
