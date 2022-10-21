package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.GetCategoryByIdOutputPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCategoryByIdAdapter implements GetCategoryByIdOutputPort {

    private final CategoryRepository categoryRepository;

    public GetCategoryByIdAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> get(Long id) {
        Optional<CategoryEntity> possibleCategory = categoryRepository.findById(id);
        return possibleCategory.map(CategoryEntity::toDomain);
    }
}
