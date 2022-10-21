package br.com.zinid.returnal.adapter.country.input;

import br.com.zinid.returnal.application.domain.country.input.CreateCountryInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CreateCountryInputPort createCountryUseCase;
    public CountryController(CreateCountryInputPort createCountryUseCase) {
        this.createCountryUseCase = createCountryUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CountryRequest countryRequest) {
        createCountryUseCase.execute(countryRequest.toDomain());
        return ResponseEntity.ok().build();
    }
}
