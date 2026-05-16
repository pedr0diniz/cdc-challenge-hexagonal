package br.com.zinid.returnal.application.domain.state.input;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.state.State;
import br.com.zinid.returnal.application.domain.state.output.CreateStateOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateStateUseCaseTest {

    @Mock
    private CreateStateOutputPort createStateOutputPort;
    @InjectMocks
    private CreateStateUseCase createStateUseCase;

    @Test
    void delegatesStateCreationToOutputPortWithCountryId() {
        // given
        State state = new State("São Paulo", 1L);

        // when
        createStateUseCase.execute(state);

        // then
        then(createStateOutputPort).should().create(state);
        assertThat(state.getName()).isEqualTo("São Paulo");
        assertThat(state.getCountryId()).isEqualTo(1L);
        assertThat(state.getCountry()).isNull();
    }

    @Test
    void delegatesStateCreationToOutputPortWithCountryObject() {
        // given
        Country country = new Country("Brazil");
        State state = new State("Rio de Janeiro", country);

        // when
        createStateUseCase.execute(state);

        // then
        then(createStateOutputPort).should().create(state);
        assertThat(state.getCountry().getName()).isEqualTo("Brazil");
        assertThat(state.getCountryId()).isNull();
    }
}
