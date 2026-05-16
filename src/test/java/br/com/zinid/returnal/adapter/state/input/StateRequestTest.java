package br.com.zinid.returnal.adapter.state.input;

import br.com.zinid.returnal.application.domain.state.State;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StateRequestTest {

    @Test
    void toDomainCreatesStateWithNameAndCountryId() {
        // given
        StateRequest request = new StateRequest("São Paulo", 1L);

        // when
        State domain = request.toDomain();

        // then
        assertThat(domain.getName()).isEqualTo("São Paulo");
        assertThat(domain.getCountryId()).isEqualTo(1L);
        assertThat(domain.getCountry()).isNull();
    }

    @Test
    void gettersReturnFieldValues() {
        // given
        StateRequest request = new StateRequest("Minas Gerais", 2L);

        // when / then
        assertThat(request.getName()).isEqualTo("Minas Gerais");
        assertThat(request.getCountryId()).isEqualTo(2L);
    }
}
