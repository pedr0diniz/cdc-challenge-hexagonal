package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.CreateCategoryOutputPort;

public class CreateCategoryUseCase implements CreateCategoryInputPort {

    private final CreateCategoryOutputPort createCategoryAdapter;
    public CreateCategoryUseCase(CreateCategoryOutputPort createCategoryAdapter) {
        this.createCategoryAdapter = createCategoryAdapter;
    }

    @Override
    public void execute(Category category) {
        createCategoryAdapter.create(category);
    }
}
