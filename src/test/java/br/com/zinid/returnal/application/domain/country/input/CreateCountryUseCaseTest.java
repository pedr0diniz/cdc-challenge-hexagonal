package br.com.zinid.returnal.application.domain.country.input;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.country.output.CreateCountryOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateCountryUseCaseTest {

    @Mock
    private CreateCountryOutputPort createCountryOutputPort;
    @InjectMocks
    private CreateCountryUseCase createCountryUseCase;

    @Test
    void delegatesCountryCreationToOutputPort() {
        // given
        Country country = new Country("Brazil");

        // when
        createCountryUseCase.execute(country);

        // then
        then(createCountryOutputPort).should().create(country);
    }
}
