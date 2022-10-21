package br.com.zinid.returnal.adapter.country.output;

import br.com.zinid.returnal.application.domain.country.Country;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "country")
public class CountryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    @Deprecated
    public CountryEntity() {
    }

    public CountryEntity(Long id) {
        this.id = id;
    }

    public CountryEntity(String name) {
        this.name = name;
    }

    public Country toDomain() {
        return new Country(name);
    }

    public CountryEntity(Country country) {
        this.name = country.getName();
    }
}
