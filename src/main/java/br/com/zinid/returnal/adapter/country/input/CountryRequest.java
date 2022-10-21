package br.com.zinid.returnal.adapter.country.input;

import br.com.zinid.returnal.adapter.country.output.CountryEntity;
import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.config.validation.UniqueField;

import javax.validation.constraints.NotBlank;

public class CountryRequest {

    @NotBlank @UniqueField(fieldName = "name", entityClass = CountryEntity.class)
    private String name;

    public String getName() {
        return name;
    }

    public Country toDomain() {
        return new Country(name);
    }
}
