package br.com.zinid.returnal.adapter.purchaser.output;

import br.com.zinid.returnal.application.domain.purchaser.Address;
import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaserEntityTest {

    private Purchaser buildPurchaser(Long stateId) {
        Address address = new Address("Rua A", "Apto 1", "São Paulo", 1L, stateId, "01310-100");
        return new Purchaser("buyer@test.com", "John", "Doe",
                "123.456.789-09", address, "11999999999");
    }

    @Test
    void constructorFromPurchaserSetsAllFields() {
        // given
        Purchaser purchaser = buildPurchaser(2L);

        // when
        PurchaserEntity entity = new PurchaserEntity(purchaser);

        // then — id is null until JPA assigns it
        assertThat(entity.getId()).isNull();
    }

    @Test
    void constructorFromPurchaserWithNullStateDoesNotSetStateEntity() {
        // given
        Purchaser purchaser = buildPurchaser(null);

        // when
        PurchaserEntity entity = new PurchaserEntity(purchaser);

        // then
        assertThat(entity.getId()).isNull();
    }

    @Test
    void idOnlyConstructorSetsId() {
        // given / when
        PurchaserEntity entity = new PurchaserEntity(5L);

        // then
        assertThat(entity.getId()).isEqualTo(5L);
    }
}
