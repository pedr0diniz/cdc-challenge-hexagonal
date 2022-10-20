package br.com.zinid.returnal.application.domain.category;

import java.util.Optional;

public interface GetCategoryByIdOutputPort {

    Optional<Category> getCategory(Long id);

}
