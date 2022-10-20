package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.category.output.GetCategoryByIdService;
import br.com.zinid.returnal.adapter.category.output.SaveCategoryService;
import br.com.zinid.returnal.application.domain.category.CategoryInputPort;
import br.com.zinid.returnal.application.domain.category.CreateCategoryUseCase;
import br.com.zinid.returnal.application.domain.category.GetCategoryByIdInputPort;
import br.com.zinid.returnal.application.domain.category.GetCategoryByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CategoryInputPort createCategoryInputPort(SaveCategoryService saveCategoryService) {
        return new CreateCategoryUseCase(saveCategoryService);
    }

    @Bean
    public GetCategoryByIdInputPort createGetCategoryByIdInputPort(GetCategoryByIdService getCategoryByIdService) {
        return new GetCategoryByIdUseCase(getCategoryByIdService);
    }

}
