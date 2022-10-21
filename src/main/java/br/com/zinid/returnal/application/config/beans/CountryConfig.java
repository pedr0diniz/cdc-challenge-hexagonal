package br.com.zinid.returnal.application.config.beans;

import br.com.zinid.returnal.adapter.country.output.CreateCountryAdapter;
import br.com.zinid.returnal.application.domain.country.input.CreateCountryInputPort;
import br.com.zinid.returnal.application.domain.country.input.CreateCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfig {

    @Bean
    public CreateCountryInputPort createCountryInputPort(CreateCountryAdapter createCountryAdapter) {
        return new CreateCountryUseCase(createCountryAdapter);
    }

}
