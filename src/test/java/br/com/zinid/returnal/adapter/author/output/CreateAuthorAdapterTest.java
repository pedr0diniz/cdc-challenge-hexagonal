package br.com.zinid.returnal.adapter.author.output;

import br.com.zinid.returnal.application.domain.author.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateAuthorAdapterTest {

    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private CreateAuthorAdapter createAuthorAdapter;

    @Test
    void convertsAuthorToEntityAndSavesIt() {
        // given
        Author author = new Author("email@test.com", "Name", "Description");
        ArgumentCaptor<AuthorEntity> captor = ArgumentCaptor.forClass(AuthorEntity.class);

        // when
        createAuthorAdapter.create(author);

        // then
        then(authorRepository).should().save(captor.capture());
        AuthorEntity saved = captor.getValue();
        assertThat(saved.toDomain().getEmail()).isEqualTo("email@test.com");
        assertThat(saved.toDomain().getName()).isEqualTo("Name");
        assertThat(saved.toDomain().getDescription()).isEqualTo("Description");
    }
}
