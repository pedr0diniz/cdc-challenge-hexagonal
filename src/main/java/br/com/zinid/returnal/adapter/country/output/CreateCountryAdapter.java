package br.com.zinid.returnal.adapter.country.output;

import br.com.zinid.returnal.application.domain.country.Country;
import br.com.zinid.returnal.application.domain.country.output.CreateCountryOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateCountryAdapter implements CreateCountryOutputPort {

    private final CountryRepository countryRepository;
    public CreateCountryAdapter(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void create(Country country) {
        CountryEntity countryEntity = new CountryEntity(country);
        countryRepository.save(countryEntity);
    }
}
