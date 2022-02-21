package br.com.alura.dojoplaces.places;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewPlaceFormValidator implements Validator {

    private PlacesRepository placesRepository;

    public NewPlaceFormValidator(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPlaceForm.class.isAssignableFrom(clazz) ;
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewPlaceForm form = (NewPlaceForm) target;
        if (placesRepository.existsByCode(form.code())){
            errors.rejectValue("code", "places.code.already.exists");
        }

    }
}
