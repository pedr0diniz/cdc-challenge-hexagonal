package br.com.zinid.returnal.application.domain.state.input;

import br.com.zinid.returnal.application.domain.state.State;

public interface CreateStateInputPort {

    void execute(State state);

}
