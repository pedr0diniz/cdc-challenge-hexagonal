package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryResponseTest {

    @Test
    void convertFromDomainMapsName() {
        // given
        Category category = new Category("Fiction");

        // when
        CategoryResponse response = CategoryResponse.convertFromDomain(category);

        // then
        assertThat(response.getName()).isEqualTo("Fiction");
    }

    @Test
    void constructorSetsName() {
        // given / when
        CategoryResponse response = new CategoryResponse("Technology");

        // then
        assertThat(response.getName()).isEqualTo("Technology");
    }
}
