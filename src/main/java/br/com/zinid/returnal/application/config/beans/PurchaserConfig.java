package br.com.zinid.returnal.application.config.beans;

import br.com.zinid.returnal.adapter.purchaser.output.CreatePurchaserAdapter;
import br.com.zinid.returnal.application.domain.purchaser.input.CreatePurchaserInputPort;
import br.com.zinid.returnal.application.domain.purchaser.input.CreatePurchaserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PurchaserConfig {

    @Bean
    public CreatePurchaserInputPort createPurchaserInputPort(CreatePurchaserAdapter createPurchaserAdapter) {
        return new CreatePurchaserUseCase(createPurchaserAdapter);
    }

}
