package br.com.zinid.returnal.application.domain.purchaser.output;

import br.com.zinid.returnal.application.domain.purchaser.Purchaser;

public interface CreatePurchaserOutputPort {

    Long create(Purchaser purchaser);

}
