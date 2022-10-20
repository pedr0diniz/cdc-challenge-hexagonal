package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;

public interface CreateCategoryInputPort {

    void create (Category category);

}
