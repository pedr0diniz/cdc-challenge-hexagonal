package br.com.zinid.returnal.application.domain.category;

import java.util.Optional;

public class GetCategoryByIdUseCase implements GetCategoryByIdInputPort {

    private final GetCategoryByIdOutputPort getCategoryByIdOutputPort;

    public GetCategoryByIdUseCase(GetCategoryByIdOutputPort getCategoryByIdOutputPort) {
        this.getCategoryByIdOutputPort = getCategoryByIdOutputPort;
    }

    @Override
    public Optional<Category> execute(Long id) {
        return getCategoryByIdOutputPort.getCategory(id);
    }
}
