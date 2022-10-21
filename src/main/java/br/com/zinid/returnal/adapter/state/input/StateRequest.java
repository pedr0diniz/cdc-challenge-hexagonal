package br.com.zinid.returnal.adapter.state.input;

import br.com.zinid.returnal.adapter.country.output.CountryEntity;
import br.com.zinid.returnal.application.domain.state.State;
import br.com.zinid.returnal.config.validation.IdMustExist;
import br.com.zinid.returnal.config.validation.UniquePerCountry;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniquePerCountry
public class StateRequest {

    @NotBlank
    private String name;

    @NotNull @IdMustExist(entityClass = CountryEntity.class)
    private Long countryId;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public StateRequest(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public State toDomain() {
        return new State(name, countryId);
    }
}
