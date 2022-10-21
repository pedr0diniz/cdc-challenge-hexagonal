package br.com.zinid.returnal.application.domain.state.input;

import br.com.zinid.returnal.application.domain.state.State;
import br.com.zinid.returnal.application.domain.state.output.CreateStateOutputPort;

public class CreateStateUseCase implements CreateStateInputPort {

    private final CreateStateOutputPort createStateAdapter;
    public CreateStateUseCase(CreateStateOutputPort createStateAdapter) {
        this.createStateAdapter = createStateAdapter;
    }

    @Override
    public void execute(State state) {
        createStateAdapter.create(state);
    }
}
