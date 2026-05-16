package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryEntityTest {

    @Test
    void toDomainMapsCategoryName() {
        // given
        CategoryEntity entity = new CategoryEntity("Fiction");

        // when
        Category domain = entity.toDomain();

        // then
        assertThat(domain.getName()).isEqualTo("Fiction");
    }

    @Test
    void toResponseMapsCategoryName() {
        // given
        CategoryEntity entity = new CategoryEntity("Technology");

        // when
        CategoryResponse response = entity.toResponse();

        // then
        assertThat(response.getName()).isEqualTo("Technology");
    }

    @Test
    void convertFromDomainCreatesEntityFromCategory() {
        // given
        Category category = new Category("Science");

        // when
        CategoryEntity entity = CategoryEntity.convertFromDomain(category);

        // then
        assertThat(entity.toDomain().getName()).isEqualTo("Science");
        assertThat(entity.getName()).isEqualTo("Science");
    }

    @Test
    void idOnlyConstructorCreatesEntityWithNullName() {
        // given / when
        CategoryEntity entity = new CategoryEntity(5L);

        // then
        assertThat(entity.getName()).isNull();
        assertThat(entity.toDomain().getName()).isNull();
    }
}
