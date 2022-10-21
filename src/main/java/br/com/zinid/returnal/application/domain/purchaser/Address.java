package br.com.zinid.returnal.application.domain.purchaser;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.state.State;

public class Address {

    private String addressOne;
    private String addressTwo;
    private String city;
    private Country country;
    private Long countryId;
    private State state;
    private Long stateId;
    private String zipCode;

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State getState() {
        return state;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address(String addressOne, String addressTwo, String city, Country country, State state, String zipCode) {
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String addressOne, String addressTwo, String city, Long countryId, Long stateId, String zipCode) {
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.zipCode = zipCode;
    }
}
