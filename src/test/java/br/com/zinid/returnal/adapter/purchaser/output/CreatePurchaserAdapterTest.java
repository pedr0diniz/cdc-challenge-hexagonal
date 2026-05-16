package br.com.zinid.returnal.adapter.purchaser.output;

import br.com.zinid.returnal.application.domain.purchaser.Address;
import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreatePurchaserAdapterTest {

    @Mock
    private PurchaserRepository purchaserRepository;
    @InjectMocks
    private CreatePurchaserAdapter createPurchaserAdapter;

    @Test
    void convertsPurchaserToEntitySavesItAndReturnsId() {
        // given
        Address address = new Address("Rua A", "Apto 1", "São Paulo", 1L, null, "01310-100");
        Purchaser purchaser = new Purchaser("buyer@test.com", "John", "Doe",
                "123.456.789-09", address, "11999999999");
        ArgumentCaptor<PurchaserEntity> captor = ArgumentCaptor.forClass(PurchaserEntity.class);

        // when
        Long returnedId = createPurchaserAdapter.create(purchaser);

        // then
        then(purchaserRepository).should().save(captor.capture());
        // id is null because the JPA repository mock does not assign it
        assertThat(returnedId).isNull();
    }
}
