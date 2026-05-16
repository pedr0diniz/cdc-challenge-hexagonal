package br.com.zinid.returnal.adapter.purchaser.output;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaserResponseTest {

    @Test
    void constructorSetsIdAndGetterReturnsIt() {
        // given / when
        PurchaserResponse response = new PurchaserResponse(42L);

        // then
        assertThat(response.getId()).isEqualTo(42L);
    }
}
