package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.CreateCategoryOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryAdapter implements CreateCategoryOutputPort {

    private final CategoryRepository categoryRepository;
    public CreateCategoryAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(Category category) {
        CategoryEntity categoryEntity = CategoryEntity.convertFromDomain(category);
        categoryRepository.save(categoryEntity);
    }
}
