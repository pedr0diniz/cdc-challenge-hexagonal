package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateCategoryAdapterTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CreateCategoryAdapter createCategoryAdapter;

    @Test
    void convertsCategoryToEntityAndSavesIt() {
        // given
        Category category = new Category("Fiction");
        ArgumentCaptor<CategoryEntity> captor = ArgumentCaptor.forClass(CategoryEntity.class);

        // when
        createCategoryAdapter.create(category);

        // then
        then(categoryRepository).should().save(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("Fiction");
    }
}
