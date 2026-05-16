package br.com.zinid.returnal.application.domain.purchaser.input;

import br.com.zinid.returnal.application.domain.purchaser.Address;
import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import br.com.zinid.returnal.application.domain.purchaser.output.CreatePurchaserOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreatePurchaserUseCaseTest {

    @Mock
    private CreatePurchaserOutputPort createPurchaserOutputPort;
    @InjectMocks
    private CreatePurchaserUseCase createPurchaserUseCase;

    @Test
    void delegatesPurchaserCreationAndReturnsId() {
        // given
        Address address = new Address("Rua A", "Apt 1", "São Paulo", 1L, null, "01310-100");
        Purchaser purchaser = new Purchaser("buyer@test.com", "John", "Doe", "123.456.789-09",
                address, "11999999999");
        given(createPurchaserOutputPort.create(purchaser)).willReturn(42L);

        // when
        Long result = createPurchaserUseCase.execute(purchaser);

        // then
        assertThat(result).isEqualTo(42L);
        then(createPurchaserOutputPort).should().create(purchaser);
    }
}
