package br.com.zinid.returnal.adapter.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRequestTest {

    private CategoryRequest buildRequest(String name) {
        CategoryRequest request = new CategoryRequest();
        ReflectionTestUtils.setField(request, "name", name);
        return request;
    }

    @Test
    void toDomainCreatesCategoryWithName() {
        // given
        CategoryRequest request = buildRequest("Fiction");

        // when
        Category domain = request.toDomain();

        // then
        assertThat(domain.getName()).isEqualTo("Fiction");
    }

    @Test
    void getterReturnsFieldValue() {
        // given
        CategoryRequest request = buildRequest("Technology");

        // when / then
        assertThat(request.getName()).isEqualTo("Technology");
    }
}
