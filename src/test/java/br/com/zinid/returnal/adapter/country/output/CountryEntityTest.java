package br.com.zinid.returnal.adapter.country.output;

import br.com.zinid.returnal.application.domain.country.Country;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountryEntityTest {

    @Test
    void toDomainMapsName() {
        // given
        CountryEntity entity = new CountryEntity("Brazil");

        // when
        Country domain = entity.toDomain();

        // then
        assertThat(domain.getName()).isEqualTo("Brazil");
    }

    @Test
    void constructorFromDomainObjectMapsName() {
        // given
        Country country = new Country("Argentina");

        // when
        CountryEntity entity = new CountryEntity(country);

        // then
        assertThat(entity.getName()).isEqualTo("Argentina");
        assertThat(entity.toDomain().getName()).isEqualTo("Argentina");
    }

    @Test
    void idOnlyConstructorCreatesEntityWithNullName() {
        // given / when
        CountryEntity entity = new CountryEntity(10L);

        // then
        assertThat(entity.getName()).isNull();
    }
}
