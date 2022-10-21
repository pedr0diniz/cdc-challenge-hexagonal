package br.com.zinid.returnal.application.domain.category.input;

import br.com.zinid.returnal.application.domain.category.Category;
import br.com.zinid.returnal.application.domain.category.output.GetCategoryByIdOutputPort;

import java.util.Optional;

public class GetCategoryByIdUseCase implements GetCategoryByIdInputPort {

    private final GetCategoryByIdOutputPort getCategoryByIdOutputPort;

    public GetCategoryByIdUseCase(GetCategoryByIdOutputPort getCategoryByIdOutputPort) {
        this.getCategoryByIdOutputPort = getCategoryByIdOutputPort;
    }

    @Override
    public Optional<Category> execute(Long id) {
        return getCategoryByIdOutputPort.get(id);
    }
}
