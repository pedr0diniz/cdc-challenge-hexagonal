package br.com.zinid.returnal.adapter.state.output;

import br.com.zinid.returnal.application.domain.state.State;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateStateAdapterTest {

    @Mock
    private StateRepository stateRepository;
    @InjectMocks
    private CreateStateAdapter createStateAdapter;

    @Test
    void convertsStateToEntityAndSavesIt() {
        // given
        State state = new State("São Paulo", 1L);
        ArgumentCaptor<StateEntity> captor = ArgumentCaptor.forClass(StateEntity.class);

        // when
        createStateAdapter.create(state);

        // then
        then(stateRepository).should().save(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("São Paulo");
    }
}
