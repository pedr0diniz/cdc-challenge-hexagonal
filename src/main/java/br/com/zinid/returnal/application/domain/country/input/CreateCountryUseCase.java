package br.com.zinid.returnal.application.domain.country.input;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.country.output.CreateCountryOutputPort;

public class CreateCountryUseCase implements CreateCountryInputPort {

    private final CreateCountryOutputPort createCountryAdapter;
    public CreateCountryUseCase(CreateCountryOutputPort createCountryAdapter) {
        this.createCountryAdapter = createCountryAdapter;
    }

    @Override
    public void execute(Country country) {
        createCountryAdapter.create(country);
    }
}
