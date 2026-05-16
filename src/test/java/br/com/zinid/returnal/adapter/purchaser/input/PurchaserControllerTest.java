package br.com.zinid.returnal.adapter.purchaser.input;

import br.com.zinid.returnal.adapter.purchaser.output.PurchaserResponse;
import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import br.com.zinid.returnal.application.domain.purchaser.input.CreatePurchaserInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PurchaserControllerTest {

    @Mock
    private CreatePurchaserInputPort createPurchaserUseCase;
    @InjectMocks
    private PurchaserController purchaserController;

    @Test
    void createPurchaserReturnsOkWithIdAndDelegatesToUseCase() {
        // given
        PurchaserRequest request = new PurchaserRequest("buyer@test.com", "John", "Doe",
                "123.456.789-09", "Rua A", "Apto 1", "São Paulo",
                1L, null, "11999999999", "01310-100");
        given(createPurchaserUseCase.execute(any(Purchaser.class))).willReturn(42L);

        // when
        ResponseEntity<?> response = purchaserController.create(request);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(((PurchaserResponse) response.getBody()).getId()).isEqualTo(42L);
        then(createPurchaserUseCase).should().execute(any(Purchaser.class));
    }
}
