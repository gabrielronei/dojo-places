package br.com.alura.dojoplaces.validations;

import br.com.alura.dojoplaces.dtos.NewPlaceForm;
import br.com.alura.dojoplaces.repositories.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NewPlaceFormValidatorTest {

    private PlaceRepository placeRepository;
    private NewPlaceFormValidator newPlaceFormValidator;

    @BeforeEach
    void setUp() {
        placeRepository = mock(PlaceRepository.class);
        when(placeRepository.existsByCode("casa")).thenReturn(true);

        newPlaceFormValidator = new NewPlaceFormValidator(placeRepository);
    }

    @Test
    void should_validate_if_the_code_already_exists() {
        NewPlaceForm newPlaceForm = new NewPlaceForm("Casa", "casa", "Guanabara", "Jundiaí");
        Errors errors = new BeanPropertyBindingResult(newPlaceForm, "newPlaceForm");

        newPlaceFormValidator.validate(newPlaceForm, errors);

        assertThat(errors.getAllErrors()).hasSize(1)
                .extracting("code")
                .containsOnly("newPlaceForm.existsBy.code");
    }

    @Test
    void should_not_return_errors() {
        NewPlaceForm newPlaceForm = new NewPlaceForm("Casa", "casa-nova", "Guanabara", "Jundiaí");
        Errors errors = new BeanPropertyBindingResult(newPlaceForm, "newPlaceForm");

        newPlaceFormValidator.validate(newPlaceForm, errors);

        assertThat(errors.hasErrors()).isFalse();
    }
}