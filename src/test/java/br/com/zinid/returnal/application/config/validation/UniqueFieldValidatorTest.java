package br.com.zinid.returnal.application.config.validation;

import br.com.zinid.returnal.adapter.author.output.AuthorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Annotation;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UniqueFieldValidatorTest {

    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    @Mock
    private ConstraintValidatorContext context;
    @InjectMocks
    private UniqueFieldValidator validator;

    @BeforeEach
    void setUp() {
        validator.initialize(new UniqueField() {
            @Override
            public String fieldName() { return "email"; }
            @Override
            public Class<?> entityClass() { return AuthorEntity.class; }
            @Override
            public String message() { return "is already in use"; }
            @Override
            public Class<?>[] groups() { return new Class[0]; }
            @SuppressWarnings("unchecked")
            @Override
            public Class<? extends Payload>[] payload() { return new Class[0]; }
            @Override
            public Class<? extends Annotation> annotationType() { return UniqueField.class; }
        });
    }

    @Test
    void returnsTrueWhenFieldValueIsUnique() {
        // given
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of());

        // when
        boolean result = validator.isValid("unique@email.com", context);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"existing@email.com", "another@existing.com"})
    void returnsFalseWhenFieldValueAlreadyExists(String existingValue) {
        // given
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of(1));

        // when
        boolean result = validator.isValid(existingValue, context);

        // then
        assertThat(result).isFalse();
    }
}
