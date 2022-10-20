package br.com.zinid.returnal.application.domain.category;

import java.util.Optional;

public interface GetCategoryByIdInputPort {

    Optional<Category> execute(Long id);

}
