package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.CreateCategoryOutputPort;

public class CreateCategoryUseCase implements CreateCategoryInputPort {

    private final CreateCategoryOutputPort createCategoryService;
    public CreateCategoryUseCase(CreateCategoryOutputPort createCategoryService) {
        this.createCategoryService = createCategoryService;
    }

    @Override
    public void create(Category category) {
        createCategoryService.save(category);
    }
}
