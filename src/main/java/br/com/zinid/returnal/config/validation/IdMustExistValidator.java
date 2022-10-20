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

public class IdMustExistValidator implements ConstraintValidator<IdMustExist, Long> {

    private final Logger logger = LoggerFactory.getLogger(IdMustExistValidator.class);
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(IdMustExist toValidate) {
        klass = toValidate.entityClass();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select x from " +
                klass.getName() +
                " x where id = :input");

        query.setParameter("input", id);

        List<?> list = query.getResultList();

        Assert.state(list.size() <= 1, "More than one record has been found for :input");

        if (list.isEmpty()) {
            logger.warn("id does not exist");
            return false;
        }

        return true;
    }
}
