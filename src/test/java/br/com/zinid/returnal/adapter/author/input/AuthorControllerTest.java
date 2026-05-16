package br.com.zinid.returnal.adapter.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.input.CreateAuthorInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AuthorControllerTest {

    @Mock
    private CreateAuthorInputPort createAuthorInputPort;
    @InjectMocks
    private AuthorController authorController;

    @Test
    void createAuthorReturnsOkAndDelegatesToUseCase() {
        // given
        Author author = new Author("email@test.com", "Name", "Description");
        AuthorRequest request = new AuthorRequest();
        ReflectionTestUtils.setField(request, "email", "email@test.com");
        ReflectionTestUtils.setField(request, "name", "Name");
        ReflectionTestUtils.setField(request, "description", "Description");

        // when
        ResponseEntity<?> response = authorController.createAuthor(request);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        then(createAuthorInputPort).should().execute(org.mockito.ArgumentMatchers.any(Author.class));
    }
}
