package br.com.alura.dojoplaces.validations;

import br.com.alura.dojoplaces.dtos.NewPlaceForm;
import br.com.alura.dojoplaces.repositories.PlaceRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NewPlaceFormValidator implements Validator {

    private final PlaceRepository placeRepository;

    public NewPlaceFormValidator(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPlaceForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if(errors.hasErrors()) return;

        NewPlaceForm newPlaceForm = (NewPlaceForm) object;

        if(placeRepository.existsByCode(newPlaceForm.getCode())) {
            errors.rejectValue("code","newPlaceForm.existsBy.code", "The code already exists");
        }
    }
}
