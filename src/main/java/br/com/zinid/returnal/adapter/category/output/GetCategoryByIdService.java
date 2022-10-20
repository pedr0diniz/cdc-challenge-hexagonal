package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.GetCategoryByIdOutputPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCategoryByIdService implements GetCategoryByIdOutputPort {

    private final CategoryRepository categoryRepository;

    public GetCategoryByIdService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> getCategory(Long id) {
        Optional<CategoryEntity> possibleCategory = categoryRepository.findById(id);
        return possibleCategory.map(CategoryEntity::toDomain);
    }
}
