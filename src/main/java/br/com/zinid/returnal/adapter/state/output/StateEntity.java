package br.com.zinid.returnal.adapter.state.output;

import br.com.zinid.returnal.adapter.country.output.CountryEntity;
import br.com.zinid.returnal.application.domain.state.State;

import javax.persistence.*;

@Entity(name = "state")
public class StateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    @Deprecated
    public StateEntity() {
    }

    public StateEntity(Long id) {
        this.id = id;
    }

    public StateEntity(State state) {
        this.name = state.getName();
        this.countryEntity = new CountryEntity(state.getCountryId());
    }

    public State toDomain() {
        return new State(name, countryEntity.toDomain());
    }
}
