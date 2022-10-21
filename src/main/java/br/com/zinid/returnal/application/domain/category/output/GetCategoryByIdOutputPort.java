package br.com.zinid.returnal.application.domain.category.output;

import br.com.zinid.returnal.application.domain.category.Category;

import java.util.Optional;

public interface GetCategoryByIdOutputPort {

    Optional<Category> get(Long id);

}
