package br.com.zinid.returnal.application.config.validation;

import br.com.zinid.returnal.adapter.purchaser.input.PurchaserRequest;
import br.com.zinid.returnal.adapter.state.output.StateEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

public class MandatoryStateWhenApplicableValidator
        implements ConstraintValidator<MandatoryStateWhenApplicable, PurchaserRequest> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(MandatoryStateWhenApplicable toValidate) {}

    @Override
    public boolean isValid(PurchaserRequest purchaserRequest, ConstraintValidatorContext validatorContext) {

        Query query = entityManager.createQuery("select s from state s where country_id = :countryId");

        query.setParameter("countryId", purchaserRequest.getCountryId());

        List<StateEntity> list = query.getResultList();

        if (list.isEmpty()) {
            return true;
        }

        for (StateEntity state: list) {
            if (Objects.equals(state.getId(), purchaserRequest.getStateId())) {
                return true;
            }
        }

        return false;

    }
}
