package br.com.zinid.returnal.application.domain.author.input;

import br.com.zinid.returnal.application.domain.author.Author;
import br.com.zinid.returnal.application.domain.author.output.GetAuthorByIdOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class GetAuthorByIdUseCaseTest {

    @Mock
    private GetAuthorByIdOutputPort getAuthorByIdOutputPort;
    @InjectMocks
    private GetAuthorByIdUseCase getAuthorByIdUseCase;

    @Test
    void returnsAuthorWhenFound() {
        // given
        Author author = new Author("email@test.com", "Name", "Description");
        given(getAuthorByIdOutputPort.get(1L)).willReturn(Optional.of(author));

        // when
        Optional<Author> result = getAuthorByIdUseCase.execute(1L);

        // then
        assertThat(result).contains(author);
        then(getAuthorByIdOutputPort).should().get(1L);
    }

    @Test
    void returnsEmptyWhenNotFound() {
        // given
        given(getAuthorByIdOutputPort.get(99L)).willReturn(Optional.empty());

        // when
        Optional<Author> result = getAuthorByIdUseCase.execute(99L);

        // then
        assertThat(result).isEmpty();
    }
}
