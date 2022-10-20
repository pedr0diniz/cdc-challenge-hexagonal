package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.author.output.GetAuthorByIdAdapter;
import br.com.zinid.returnal.adapter.author.output.CreateAuthorAdapter;
import br.com.zinid.returnal.application.domain.author.input.CreateAuthorInputPort;
import br.com.zinid.returnal.application.domain.author.input.CreateAuthorUseCase;
import br.com.zinid.returnal.application.domain.author.input.GetAuthorByIdInputPort;
import br.com.zinid.returnal.application.domain.author.input.GetAuthorByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Creates the domain beans for them to be autowired by Spring Boot
// In other words, allows Spring to manage and inject dependencies that aren't annotated
public class AuthorConfig {

    @Bean
    // Why not inject an CreateAuthorOutputPort?
    // Because the interface is not managed by Spring.
    // Its implementation, CreateAuthorAdapter, however, is managed.
    // Therefore, we pass CreateAuthorAdapter as a parameter for the CreateAuthorUseCase implementation.
    public CreateAuthorInputPort createAuthorInputPort(CreateAuthorAdapter createAuthorAdapter) {
        return new CreateAuthorUseCase(createAuthorAdapter);
    }

    @Bean
    public GetAuthorByIdInputPort createGetAuthorByIdInputPort (GetAuthorByIdAdapter getAuthorByIdAdapter) {
        return new GetAuthorByIdUseCase(getAuthorByIdAdapter);
    }
}
