package br.com.zinid.returnal.application.config.validation;

import br.com.zinid.returnal.adapter.state.input.StateRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UniqueStatePerCountryValidatorTest {

    @Mock
    private EntityManager entityManager;
    @Mock
    private Query query;
    @Mock
    private ConstraintValidatorContext context;
    @InjectMocks
    private UniqueStatePerCountryValidator validator;

    static Stream<StateRequest> uniqueStateRequests() {
        return Stream.of(
                new StateRequest("Minas Gerais", 1L),
                new StateRequest("Bahia", 2L),
                new StateRequest("Paraná", 3L)
        );
    }

    @ParameterizedTest
    @MethodSource("uniqueStateRequests")
    void returnsTrueWhenStateNameIsUniqueInCountry(StateRequest request) {
        // given
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of());

        // when
        boolean result = validator.isValid(request, context);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void returnsFalseWhenStateNameAlreadyExistsInCountry() {
        // given
        StateRequest request = new StateRequest("São Paulo", 1L);
        given(entityManager.createQuery(anyString())).willReturn(query);
        given(query.setParameter(anyString(), any())).willReturn(query);
        given(query.getResultList()).willReturn(List.of("existing"));

        // when
        boolean result = validator.isValid(request, context);

        // then
        assertThat(result).isFalse();
    }
}
