package br.com.zinid.returnal.adapter.category.output;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.CategoryOutputPort;
import org.springframework.stereotype.Service;

@Service
public class SaveCategoryService implements CategoryOutputPort {

    private final CategoryRepository categoryRepository;
    public SaveCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        CategoryEntity categoryEntity = CategoryEntity.convertFromDomain(category);
        categoryRepository.save(categoryEntity);
    }
}
