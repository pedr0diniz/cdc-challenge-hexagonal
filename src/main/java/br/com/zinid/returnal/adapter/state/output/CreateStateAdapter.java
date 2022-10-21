package br.com.zinid.returnal.adapter.state.output;

import br.com.zinid.returnal.application.domain.state.State;
import br.com.zinid.returnal.application.domain.state.output.CreateStateOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateStateAdapter implements CreateStateOutputPort {

    private final StateRepository stateRepository;
    public CreateStateAdapter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public void create(State state) {
        StateEntity stateEntity = new StateEntity(state);
        stateRepository.save(stateEntity);
    }
}
