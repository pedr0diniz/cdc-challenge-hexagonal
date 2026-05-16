package br.com.zinid.returnal.adapter.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorRequestTest {

    private AuthorRequest buildRequest(String email, String name, String description) {
        AuthorRequest request = new AuthorRequest();
        ReflectionTestUtils.setField(request, "email", email);
        ReflectionTestUtils.setField(request, "name", name);
        ReflectionTestUtils.setField(request, "description", description);
        return request;
    }

    @Test
    void toDomainCreatesAuthorWithCorrectFields() {
        // given
        AuthorRequest request = buildRequest("email@test.com", "Name", "Description");

        // when
        Author domain = request.toDomain();

        // then
        assertThat(domain.getEmail()).isEqualTo("email@test.com");
        assertThat(domain.getName()).isEqualTo("Name");
        assertThat(domain.getDescription()).isEqualTo("Description");
        assertThat(domain.getRegistrationDate()).isNotNull();
    }

    @Test
    void gettersReturnFieldValues() {
        // given
        AuthorRequest request = buildRequest("e@e.com", "The Name", "Some desc");

        // when / then
        assertThat(request.getEmail()).isEqualTo("e@e.com");
        assertThat(request.getName()).isEqualTo("The Name");
        assertThat(request.getDescription()).isEqualTo("Some desc");
    }
}
