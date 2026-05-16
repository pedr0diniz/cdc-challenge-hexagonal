package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.CreateCategoryOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateCategoryUseCaseTest {

    @Mock
    private CreateCategoryOutputPort createCategoryOutputPort;
    @InjectMocks
    private CreateCategoryUseCase createCategoryUseCase;

    @Test
    void delegatesCategoryCreationToOutputPort() {
        // given
        Category category = new Category("Fiction");

        // when
        createCategoryUseCase.execute(category);

        // then
        then(createCategoryOutputPort).should().create(category);
    }
}
