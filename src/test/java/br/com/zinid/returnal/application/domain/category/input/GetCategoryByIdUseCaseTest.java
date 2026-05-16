package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.GetCategoryByIdOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetCategoryByIdUseCaseTest {

    @Mock
    private GetCategoryByIdOutputPort getCategoryByIdOutputPort;
    @InjectMocks
    private GetCategoryByIdUseCase getCategoryByIdUseCase;

    @Test
    void returnsCategoryWhenFound() {
        // given
        Category category = new Category("Fiction");
        given(getCategoryByIdOutputPort.get(1L)).willReturn(Optional.of(category));

        // when
        Optional<Category> result = getCategoryByIdUseCase.execute(1L);

        // then
        assertThat(result).contains(category);
    }

    @Test
    void returnsEmptyWhenNotFound() {
        // given
        given(getCategoryByIdOutputPort.get(99L)).willReturn(Optional.empty());

        // when
        Optional<Category> result = getCategoryByIdUseCase.execute(99L);

        // then
        assertThat(result).isEmpty();
    }
}
