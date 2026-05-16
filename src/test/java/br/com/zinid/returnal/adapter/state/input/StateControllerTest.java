package br.com.zinid.returnal.adapter.state.input;

import br.com.zinid.returnal.application.domain.state.State;
import br.com.zinid.returnal.application.domain.state.input.CreateStateInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class StateControllerTest {

    @Mock
    private CreateStateInputPort createStateUseCase;
    @InjectMocks
    private StateController stateController;

    @Test
    void createStateReturnsOkAndDelegatesToUseCase() {
        // given
        StateRequest request = new StateRequest("São Paulo", 1L);

        // when
        ResponseEntity<?> response = stateController.create(request);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        then(createStateUseCase).should().execute(any(State.class));
    }
}
