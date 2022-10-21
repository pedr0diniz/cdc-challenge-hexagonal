package br.com.zinid.returnal.adapter.state.input;

import br.com.zinid.returnal.application.domain.state.input.CreateStateInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/state")
public class StateController {

    private final CreateStateInputPort createStateUseCase;
    public StateController(CreateStateInputPort createStateUseCase) {
        this.createStateUseCase = createStateUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid StateRequest stateRequest) {
        createStateUseCase.execute(stateRequest.toDomain());
        return ResponseEntity.ok().build();
    }
}
