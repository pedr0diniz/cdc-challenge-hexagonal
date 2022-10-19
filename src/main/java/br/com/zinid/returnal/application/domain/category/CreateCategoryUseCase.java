package br.com.zinid.returnal.application.domain.category;

public class CreateCategoryUseCase implements CategoryInputPort {

    private final CategoryOutputPort saveCategoryService;
    public CreateCategoryUseCase(CategoryOutputPort saveCategoryService) {
        this.saveCategoryService = saveCategoryService;
    }

    @Override
    public void create(Category category) {
        saveCategoryService.save(category);
    }
}
