package br.com.zinid.returnal.application.domain.country.output;

import br.com.zinid.returnal.application.domain.country.Country;

public interface CreateCountryOutputPort {

    void create(Country country);

}
