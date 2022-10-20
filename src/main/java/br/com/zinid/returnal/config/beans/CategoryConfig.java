package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.category.output.GetCategoryByIdAdapter;
import br.com.zinid.returnal.adapter.category.output.CreateCategoryAdapter;
import br.com.zinid.returnal.application.domain.category.input.CreateCategoryInputPort;
import br.com.zinid.returnal.application.domain.category.input.CreateCategoryUseCase;
import br.com.zinid.returnal.application.domain.category.input.GetCategoryByIdInputPort;
import br.com.zinid.returnal.application.domain.category.input.GetCategoryByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CreateCategoryInputPort createCategoryInputPort(CreateCategoryAdapter createCategoryAdapter) {
        return new CreateCategoryUseCase(createCategoryAdapter);
    }

    @Bean
    public GetCategoryByIdInputPort createGetCategoryByIdInputPort(GetCategoryByIdAdapter getCategoryByIdAdapter) {
        return new GetCategoryByIdUseCase(getCategoryByIdAdapter);
    }

}
