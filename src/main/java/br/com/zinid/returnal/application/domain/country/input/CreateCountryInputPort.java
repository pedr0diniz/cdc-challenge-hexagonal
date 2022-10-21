package br.com.zinid.returnal.application.domain.country.input;

import br.com.zinid.returnal.application.domain.country.Country;

public interface CreateCountryInputPort {

    void execute(Country country);

}
