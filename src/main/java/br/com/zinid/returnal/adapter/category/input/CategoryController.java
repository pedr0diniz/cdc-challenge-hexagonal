package br.com.zinid.returnal.adapter.category.input;

import br.com.zinid.returnal.application.domain.category.input.CreateCategoryInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CreateCategoryInputPort createCategoryUseCase;
    public CategoryController(CreateCategoryInputPort createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        createCategoryUseCase.execute(categoryRequest.toDomain());
        return ResponseEntity.ok().build();
    }
}
