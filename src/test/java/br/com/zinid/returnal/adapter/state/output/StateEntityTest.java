package br.com.zinid.returnal.adapter.state.output;

import br.com.zinid.returnal.application.domain.state.State;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class StateEntityTest {

    @Test
    void constructorFromStateWithCountryIdSetsNameAndCountryEntity() {
        // given
        State state = new State("São Paulo", 1L);

        // when
        StateEntity entity = new StateEntity(state);

        // then
        assertThat(entity.getName()).isEqualTo("São Paulo");
        assertThat(entity.getCountryEntity()).isNotNull();
    }

    @Test
    void toDomainMapsNameAndDelegatesCountryConversion() {
        // given
        State state = new State("Rio de Janeiro", 1L);
        StateEntity entity = new StateEntity(state);

        // when
        State domain = entity.toDomain();

        // then
        assertThat(domain.getName()).isEqualTo("Rio de Janeiro");
        assertThat(domain.getCountry()).isNotNull();
    }

    @Test
    void idOnlyConstructorSetsIdAndLeavesOtherFieldsNull() {
        // given / when
        StateEntity entity = new StateEntity(7L);

        // then
        assertThat(entity.getId()).isEqualTo(7L);
        assertThat(entity.getName()).isNull();
        assertThat(entity.getCountryEntity()).isNull();
    }
}
