package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;

import java.util.Optional;

public interface GetCategoryByIdInputPort {

    Optional<Category> execute(Long id);

}
