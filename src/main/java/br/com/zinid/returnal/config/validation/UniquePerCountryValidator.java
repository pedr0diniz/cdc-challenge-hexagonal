package br.com.zinid.returnal.config.validation;

import br.com.zinid.returnal.adapter.state.input.StateRequest;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniquePerCountryValidator implements ConstraintValidator<UniquePerCountry, StateRequest> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniquePerCountry toValidate) {}

    @Override
    public boolean isValid(StateRequest stateRequest, ConstraintValidatorContext validatorContext) {

        Query query = entityManager.createQuery("select s from state s where name = :stateName " +
                " and country_id = :countryId");

        query.setParameter("stateName", stateRequest.getName());
        query.setParameter("countryId", stateRequest.getCountryId());

        List<?> list = query.getResultList();

        Assert.state(list.size() <= 1, "More than one state was :stateName was found in this country");

        return list.isEmpty();
    }
}
