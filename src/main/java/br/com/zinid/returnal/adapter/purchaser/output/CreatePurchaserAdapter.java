package br.com.zinid.returnal.adapter.purchaser.output;

import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import br.com.zinid.returnal.application.domain.purchaser.output.CreatePurchaserOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePurchaserAdapter implements CreatePurchaserOutputPort {

    private final PurchaserRepository purchaserRepository;
    public CreatePurchaserAdapter(PurchaserRepository purchaserRepository) {
        this.purchaserRepository = purchaserRepository;
    }

    @Override
    public Long create(Purchaser purchaser) {
        PurchaserEntity purchaserEntity = new PurchaserEntity(purchaser);
        purchaserRepository.save(purchaserEntity);

        return purchaserEntity.getId();
    }
}
