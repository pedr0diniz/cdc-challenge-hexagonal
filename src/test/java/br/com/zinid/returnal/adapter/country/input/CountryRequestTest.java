package br.com.zinid.returnal.adapter.country.input;

import br.com.zinid.returnal.application.domain.country.Country;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

class CountryRequestTest {

    private CountryRequest buildRequest(String name) {
        CountryRequest request = new CountryRequest();
        ReflectionTestUtils.setField(request, "name", name);
        return request;
    }

    @Test
    void toDomainCreatesCountryWithName() {
        // given
        CountryRequest request = buildRequest("Brazil");

        // when
        Country domain = request.toDomain();

        // then
        assertThat(domain.getName()).isEqualTo("Brazil");
    }

    @Test
    void getterReturnsFieldValue() {
        // given
        CountryRequest request = buildRequest("Argentina");

        // when / then
        assertThat(request.getName()).isEqualTo("Argentina");
    }
}
