package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorEntityTest {

    @Test
    void toDomainMapsAllFields() {
        // given
        OffsetDateTime date = OffsetDateTime.now().minusDays(1);
        AuthorEntity entity = new AuthorEntity("email@test.com", "Name", "Desc", date);

        // when
        Author domain = entity.toDomain();

        // then
        assertThat(domain.getEmail()).isEqualTo("email@test.com");
        assertThat(domain.getName()).isEqualTo("Name");
        assertThat(domain.getDescription()).isEqualTo("Desc");
        assertThat(domain.getRegistrationDate()).isNotNull();
    }

    @Test
    void toResponseMapsNameAndDescription() {
        // given
        AuthorEntity entity = new AuthorEntity("email@test.com", "Name", "Desc", OffsetDateTime.now());

        // when
        AuthorResponse response = entity.toResponse();

        // then
        assertThat(response.getName()).isEqualTo("Name");
        assertThat(response.getDescription()).isEqualTo("Desc");
    }

    @Test
    void convertFromDomainCreatesEntityWithSameData() {
        // given
        Author author = new Author("email@test.com", "Name", "Description");

        // when
        AuthorEntity entity = AuthorEntity.convertFromDomain(author);
        Author roundTripped = entity.toDomain();

        // then
        assertThat(roundTripped.getEmail()).isEqualTo("email@test.com");
        assertThat(roundTripped.getName()).isEqualTo("Name");
        assertThat(roundTripped.getDescription()).isEqualTo("Description");
        assertThat(roundTripped.getRegistrationDate()).isNotNull();
    }

    @Test
    void idOnlyConstructorAllowsIdRetrieval() {
        // given / when
        AuthorEntity entity = new AuthorEntity(5L);

        // then - entity created with only id has null fields
        assertThat(entity.toDomain().getEmail()).isNull();
        assertThat(entity.toDomain().getName()).isNull();
    }
}
