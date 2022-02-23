package br.com.alura.dojoplaces.validations;

import br.com.alura.dojoplaces.dtos.EditPlaceForm;
import br.com.alura.dojoplaces.repositories.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EditPlaceFormValidatorTest {

    private PlaceRepository placeRepository;
    private EditPlaceFormValidator editPlaceFormValidator;

    @BeforeEach
    void setUp() {
        placeRepository = mock(PlaceRepository.class);
        when(placeRepository.existsByCodeAndIdNot("casa", 1L)).thenReturn(true);

        editPlaceFormValidator = new EditPlaceFormValidator(placeRepository);
    }

    @Test
    void should_validate_if_the_code_already_exists() {
        EditPlaceForm editPlaceForm = anEditPlaceForm(1L, "Casa", "casa", "Guanabara", "Jundiaí");
        Errors errors = new BeanPropertyBindingResult(editPlaceForm, "editPlaceForm");

        editPlaceFormValidator.validate(editPlaceForm, errors);

        assertThat(errors.getAllErrors()).hasSize(1)
                .extracting("code")
                .containsOnly("editPlaceForm.existsBy.code");
    }

    @Test
    void should_not_return_errors() {
        EditPlaceForm editPlaceForm = anEditPlaceForm(1L, "Casa", "casa-nova", "Guanabara", "Jundiaí");
        Errors errors = new BeanPropertyBindingResult(editPlaceForm, "editPlaceForm");

        editPlaceFormValidator.validate(editPlaceForm, errors);

        assertThat(errors.hasErrors()).isFalse();
    }

    private EditPlaceForm anEditPlaceForm(Long id, String name, String code, String neighborhood, String city) {
        EditPlaceForm editPlaceForm = new EditPlaceForm();
        editPlaceForm.setId(id);
        editPlaceForm.setName(name);
        editPlaceForm.setCode(code);
        editPlaceForm.setNeighborhood(neighborhood);
        editPlaceForm.setCity(city);
        return editPlaceForm;
    }
}