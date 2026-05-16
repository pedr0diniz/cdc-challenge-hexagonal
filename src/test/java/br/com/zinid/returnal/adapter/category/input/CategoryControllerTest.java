package br.com.zinid.returnal.adapter.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.input.CreateCategoryInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CreateCategoryInputPort createCategoryUseCase;
    @InjectMocks
    private CategoryController categoryController;

    @Test
    void createCategoryReturnsOkAndDelegatesToUseCase() {
        // given
        CategoryRequest request = new CategoryRequest();
        ReflectionTestUtils.setField(request, "name", "Fiction");

        // when
        ResponseEntity<?> response = categoryController.createCategory(request);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        then(createCategoryUseCase).should().execute(any(Category.class));
    }
}
