package br.com.zinid.returnal.application.domain.state.output;

import br.com.zinid.returnal.application.domain.state.State;

public interface CreateStateOutputPort {

    void create(State state);

}
