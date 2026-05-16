package br.com.zinid.returnal.adapter.purchaser.input;

import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaserRequestTest {

    private PurchaserRequest buildRequest(Long stateId) {
        return new PurchaserRequest("buyer@test.com", "John", "Doe",
                "123.456.789-09", "Rua A", "Apto 1", "São Paulo",
                1L, stateId, "11999999999", "01310-100");
    }

    @Test
    void toDomainMapsPurchaserFieldsCorrectly() {
        // given
        PurchaserRequest request = buildRequest(2L);

        // when
        Purchaser domain = request.toDomain();

        // then
        assertThat(domain.getEmail()).isEqualTo("buyer@test.com");
        assertThat(domain.getName()).isEqualTo("John");
        assertThat(domain.getSurname()).isEqualTo("Doe");
        assertThat(domain.getDocument()).isEqualTo("123.456.789-09");
        assertThat(domain.getPhoneNumber()).isEqualTo("11999999999");
    }

    @Test
    void toDomainMapsAddressFieldsCorrectly() {
        // given
        PurchaserRequest request = buildRequest(2L);

        // when
        Purchaser domain = request.toDomain();

        // then
        assertThat(domain.getAddress().getAddressOne()).isEqualTo("Rua A");
        assertThat(domain.getAddress().getAddressTwo()).isEqualTo("Apto 1");
        assertThat(domain.getAddress().getCity()).isEqualTo("São Paulo");
        assertThat(domain.getAddress().getCountryId()).isEqualTo(1L);
        assertThat(domain.getAddress().getStateId()).isEqualTo(2L);
        assertThat(domain.getAddress().getZipCode()).isEqualTo("01310-100");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(longs = {1L, 5L})
    void toDomainHandlesNullAndNonNullStateId(Long stateId) {
        // given
        PurchaserRequest request = buildRequest(stateId);

        // when
        Purchaser domain = request.toDomain();

        // then
        assertThat(domain.getAddress().getStateId()).isEqualTo(stateId);
    }

    @Test
    void gettersReturnFieldValues() {
        // given
        PurchaserRequest request = buildRequest(3L);

        // when / then
        assertThat(request.getEmail()).isEqualTo("buyer@test.com");
        assertThat(request.getName()).isEqualTo("John");
        assertThat(request.getSurname()).isEqualTo("Doe");
        assertThat(request.getDocument()).isEqualTo("123.456.789-09");
        assertThat(request.getAddressOne()).isEqualTo("Rua A");
        assertThat(request.getAddressTwo()).isEqualTo("Apto 1");
        assertThat(request.getCity()).isEqualTo("São Paulo");
        assertThat(request.getCountryId()).isEqualTo(1L);
        assertThat(request.getStateId()).isEqualTo(3L);
        assertThat(request.getPhoneNumber()).isEqualTo("11999999999");
        assertThat(request.getZipCode()).isEqualTo("01310-100");
    }
}
