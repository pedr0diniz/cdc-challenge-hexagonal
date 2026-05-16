package br.com.zinid.returnal.application.domain.purchaser;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.state.State;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {

    @Test
    void constructorWithIdsSetsIdFields() {
        // given / when
        Address address = new Address("Rua A", "Apto 1", "São Paulo", 1L, 2L, "01310-100");

        // then
        assertThat(address.getAddressOne()).isEqualTo("Rua A");
        assertThat(address.getAddressTwo()).isEqualTo("Apto 1");
        assertThat(address.getCity()).isEqualTo("São Paulo");
        assertThat(address.getCountryId()).isEqualTo(1L);
        assertThat(address.getStateId()).isEqualTo(2L);
        assertThat(address.getZipCode()).isEqualTo("01310-100");
        assertThat(address.getCountry()).isNull();
        assertThat(address.getState()).isNull();
    }

    @Test
    void constructorWithDomainObjectsSetsObjectFields() {
        // given
        Country country = new Country("Brazil");
        State state = new State("São Paulo", country);

        // when
        Address address = new Address("Rua B", "Casa", "Campinas", country, state, "13000-000");

        // then
        assertThat(address.getCountry().getName()).isEqualTo("Brazil");
        assertThat(address.getState().getName()).isEqualTo("São Paulo");
        assertThat(address.getCountryId()).isNull();
        assertThat(address.getStateId()).isNull();
    }
}
