package br.com.zinid.returnal.adapter.category.input;

import br.com.zinid.returnal.application.domain.category.CategoryInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryInputPort createCategoryService;
    public CategoryController(CategoryInputPort createCategoryService) {
        this.createCategoryService = createCategoryService;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        createCategoryService.create(categoryRequest.toDomain());
        return ResponseEntity.ok().build();
    }
}
