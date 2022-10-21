package br.com.zinid.returnal.application.domain.category.output;

import br.com.zinid.returnal.application.domain.category.Category;

public interface CreateCategoryOutputPort {

    void create(Category category);

}
