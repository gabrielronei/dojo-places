package br.com.alura.dojoplaces.validations;

import br.com.alura.dojoplaces.dtos.EditPlaceForm;
import br.com.alura.dojoplaces.repositories.PlaceRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EditPlaceFormValidator implements Validator {

    private final PlaceRepository placeRepository;

    public EditPlaceFormValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EditPlaceForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()) return;

        EditPlaceForm editPlaceForm = (EditPlaceForm) object;

        if(placeRepository.existsByCodeAndIdNot(editPlaceForm.getCode(), editPlaceForm.getId())) {
            errors.rejectValue("code","editPlaceForm.existsBy.code", "The code already exists");
        }
    }
}
