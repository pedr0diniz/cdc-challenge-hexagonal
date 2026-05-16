package br.com.zinid.returnal.application.config.validation;

import br.com.zinid.returnal.adapter.purchaser.input.PurchaserRequest;
import br.com.zinid.returnal.adapter.state.output.StateEntity;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MandatoryStateWhenApplicableValidatorTest {

    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    @Mock
    private ConstraintValidatorContext context;
    @InjectMocks
    private MandatoryStateWhenApplicableValidator validator;

    private PurchaserRequest buildRequest(Long stateId) {
        return new PurchaserRequest("buyer@test.com", "John", "Doe", "123.456.789-09",
                "Rua A", "Apt 1", "São Paulo", 1L, stateId, "11999999999", "01310-100");
    }

    @Test
    void returnsTrueWhenCountryHasNoStates() {
        // given
        PurchaserRequest request = buildRequest(null);
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of());

        // when
        boolean result = validator.isValid(request, context);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void returnsTrueWhenProvidedStateMatchesOneOfCountryStates(long stateId) {
        // given
        PurchaserRequest request = buildRequest(stateId);
        StateEntity matchingState = new StateEntity(stateId);
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of(matchingState));

        // when
        boolean result = validator.isValid(request, context);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void returnsFalseWhenCountryHasStatesButProvidedStateDoesNotMatch() {
        // given
        PurchaserRequest request = buildRequest(99L);
        StateEntity existingState = new StateEntity(1L);
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of(existingState));

        // when
        boolean result = validator.isValid(request, context);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void returnsFalseWhenNoStateProvidedButCountryHasStates() {
        // given
        PurchaserRequest request = buildRequest(null);
        StateEntity existingState = new StateEntity(1L);
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of(existingState));

        // when
        boolean result = validator.isValid(request, context);

        // then
        assertThat(result).isFalse();
    }
}
