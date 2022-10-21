package br.com.zinid.returnal.application.domain.purchaser.input;

import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import br.com.zinid.returnal.application.domain.purchaser.output.CreatePurchaserOutputPort;

public class CreatePurchaserUseCase implements CreatePurchaserInputPort {

    private final CreatePurchaserOutputPort createPurchaserAdapter;
    public CreatePurchaserUseCase(CreatePurchaserOutputPort createPurchaserAdapter) {
        this.createPurchaserAdapter = createPurchaserAdapter;
    }

    @Override
    public Long execute(Purchaser purchaser) {
        return createPurchaserAdapter.create(purchaser);
    }
}
