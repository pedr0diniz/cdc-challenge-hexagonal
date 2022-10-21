package br.com.zinid.returnal.application.domain.purchaser.input;

import br.com.zinid.returnal.application.domain.purchaser.Purchaser;

public interface CreatePurchaserInputPort {

    Long execute(Purchaser purchaser);

}
