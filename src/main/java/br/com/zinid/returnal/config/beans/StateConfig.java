package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.state.output.CreateStateAdapter;
import br.com.zinid.returnal.application.domain.state.input.CreateStateInputPort;
import br.com.zinid.returnal.application.domain.state.input.CreateStateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateConfig {

    @Bean
    public CreateStateInputPort createStateInputPort(CreateStateAdapter createStateAdapter) {
        return new CreateStateUseCase(createStateAdapter);
    }

}
