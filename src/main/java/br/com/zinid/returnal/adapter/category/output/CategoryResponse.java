package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;

public class CategoryResponse {

    private String name;

    public String getName() {
        return name;
    }

    public static CategoryResponse convertFromDomain(Category category) {
        return new CategoryResponse(category.getName());
    }

    public CategoryResponse(String name) {
        this.name = name;
    }
}
