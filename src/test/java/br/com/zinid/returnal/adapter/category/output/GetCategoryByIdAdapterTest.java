package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetCategoryByIdAdapterTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private GetCategoryByIdAdapter getCategoryByIdAdapter;

    @Test
    void returnsMappedDomainCategoryWhenFound() {
        // given
        CategoryEntity entity = new CategoryEntity("Fiction");
        given(categoryRepository.findById(1L)).willReturn(Optional.of(entity));

        // when
        Optional<Category> result = getCategoryByIdAdapter.get(1L);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Fiction");
    }

    @Test
    void returnsEmptyWhenNotFound() {
        // given
        given(categoryRepository.findById(99L)).willReturn(Optional.empty());

        // when
        Optional<Category> result = getCategoryByIdAdapter.get(99L);

        // then
        assertThat(result).isEmpty();
    }
}
