package br.com.zinid.returnal.adapter.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.CategoryInputPort;
import br.com.zinid.returnal.application.domain.category.CategoryOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements CategoryInputPort {

    private final CategoryOutputPort saveCategoryService;
    public CreateCategoryService(CategoryOutputPort saveCategoryService) {
        this.saveCategoryService = saveCategoryService;
    }

    @Override
    public void create(Category category) {
        saveCategoryService.save(category);
    }
}
