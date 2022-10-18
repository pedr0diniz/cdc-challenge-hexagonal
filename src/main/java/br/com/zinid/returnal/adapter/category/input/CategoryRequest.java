package br.com.zinid.returnal.adapter.category.input;

import br.com.zinid.returnal.adapter.category.output.CategoryEntity;
import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.validation.UniqueField;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank @UniqueField(fieldName = "name", entityClass = CategoryEntity.class)
    private String name;

    public String getName() {
        return name;
    }

    public Category toDomain() {
        return new Category(name);
    }
}
