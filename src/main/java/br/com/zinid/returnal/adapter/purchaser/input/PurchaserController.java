package br.com.zinid.returnal.adapter.purchaser.input;

import br.com.zinid.returnal.adapter.purchaser.output.PurchaserResponse;
import br.com.zinid.returnal.application.domain.purchaser.input.CreatePurchaserInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchaser")
public class PurchaserController {

    private final CreatePurchaserInputPort createPurchaserUseCase;
    public PurchaserController(CreatePurchaserInputPort createPurchaserUseCase) {
        this.createPurchaserUseCase = createPurchaserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PurchaserRequest purchaserRequest) {
        Long purchaserId = createPurchaserUseCase.execute(purchaserRequest.toDomain());

        return ResponseEntity.ok(new PurchaserResponse(purchaserId));
    }
}
