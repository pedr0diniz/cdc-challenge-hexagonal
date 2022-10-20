package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.author.output.GetAuthorByIdService;
import br.com.zinid.returnal.adapter.author.output.SaveAuthorService;
import br.com.zinid.returnal.application.domain.author.AuthorInputPort;
import br.com.zinid.returnal.application.domain.author.CreateAuthorUseCase;
import br.com.zinid.returnal.application.domain.author.GetAuthorByIdInputPort;
import br.com.zinid.returnal.application.domain.author.GetAuthorByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Creates the domain beans for them to be autowired by Spring Boot
// In other words, allows Spring to manage and inject dependencies that aren't annotated
public class AuthorConfig {

    @Bean
    // Why not inject an AuthorOutputPort?
    // Because the interface is not managed by Spring.
    // Its implementation, SaveAuthorService, however, is managed.
    // Therefore, we pass SaveAuthorService as a parameter for the CreateAuthorUseCase implementation.
    public AuthorInputPort createAuthorInputPort(SaveAuthorService saveAuthorService) {
        return new CreateAuthorUseCase(saveAuthorService);
    }

    @Bean
    public GetAuthorByIdInputPort createGetAuthorByIdInputPort (GetAuthorByIdService getAuthorByIdService) {
        return new GetAuthorByIdUseCase(getAuthorByIdService);
    }
}
