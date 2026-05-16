package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetAuthorByIdAdapterTest {

    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private GetAuthorByIdAdapter getAuthorByIdAdapter;

    @Test
    void returnsMappedDomainAuthorWhenFound() {
        // given
        AuthorEntity entity = new AuthorEntity("email@test.com", "Name", "Desc", OffsetDateTime.now());
        given(authorRepository.findById(1L)).willReturn(Optional.of(entity));

        // when
        Optional<Author> result = getAuthorByIdAdapter.get(1L);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("email@test.com");
        assertThat(result.get().getName()).isEqualTo("Name");
        assertThat(result.get().getDescription()).isEqualTo("Desc");
        assertThat(result.get().getRegistrationDate()).isNotNull();
    }

    @Test
    void returnsEmptyWhenNotFound() {
        // given
        given(authorRepository.findById(99L)).willReturn(Optional.empty());

        // when
        Optional<Author> result = getAuthorByIdAdapter.get(99L);

        // then
        assertThat(result).isEmpty();
    }
}
