package br.com.zinid.returnal.adapter.country.input;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.country.input.CreateCountryInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CountryControllerTest {

    @Mock
    private CreateCountryInputPort createCountryUseCase;
    @InjectMocks
    private CountryController countryController;

    @Test
    void createCountryReturnsOkAndDelegatesToUseCase() {
        // given
        CountryRequest request = new CountryRequest();
        ReflectionTestUtils.setField(request, "name", "Brazil");

        // when
        ResponseEntity<?> response = countryController.create(request);

        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        then(createCountryUseCase).should().execute(any(Country.class));
    }
}
