package br.com.zinid.returnal.config.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

    private final Logger logger = LoggerFactory.getLogger(UniqueFieldValidator.class);

    private String entityAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueField toValidate) {
        entityAttribute = toValidate.fieldName();
        klass = toValidate.entityClass();
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from " +
                klass.getName() +
                " where " +
                entityAttribute +
                " = :input");

        query.setParameter("input", fieldValue);

        List<?> list = query.getResultList();

        Assert.state(list.size() <= 1, "More than one record has been found for :input");

        if (!list.isEmpty()) {
            logger.warn(entityAttribute + " is already in use");
            return false;
        }
        return true;
    }
}
