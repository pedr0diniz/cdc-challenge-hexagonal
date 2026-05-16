package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.CreateAuthorOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateAuthorUseCaseTest {

    @Mock
    private CreateAuthorOutputPort createAuthorOutputPort;
    @InjectMocks
    private CreateAuthorUseCase createAuthorUseCase;

    @Test
    void delegatesAuthorCreationToOutputPort() {
        // given
        Author author = new Author("email@test.com", "Name", "Description");

        // when
        createAuthorUseCase.execute(author);

        // then
        then(createAuthorOutputPort).should().create(author);
    }
}
