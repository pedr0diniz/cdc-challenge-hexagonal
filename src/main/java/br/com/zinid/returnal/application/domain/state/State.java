package br.com.zinid.returnal.application.domain.state;

import br.com.zinid.returnal.application.domain.country.Country;

public class State {

    private String name;
    private Country country;
    private Long countryId;

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public State(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }
}
