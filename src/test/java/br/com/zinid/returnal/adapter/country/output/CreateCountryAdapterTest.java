package br.com.zinid.returnal.adapter.country.output;

import br.com.zinid.returnal.application.domain.country.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CreateCountryAdapterTest {

    @Mock
    private CountryRepository countryRepository;
    @InjectMocks
    private CreateCountryAdapter createCountryAdapter;

    @Test
    void convertsCountryToEntityAndSavesIt() {
        // given
        Country country = new Country("Brazil");
        ArgumentCaptor<CountryEntity> captor = ArgumentCaptor.forClass(CountryEntity.class);

        // when
        createCountryAdapter.create(country);

        // then
        then(countryRepository).should().save(captor.capture());
        assertThat(captor.getValue().getName()).isEqualTo("Brazil");
    }
}
