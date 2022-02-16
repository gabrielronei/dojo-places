package br.com.alura.dojoplaces.places;

import javax.validation.constraints.*;

public record EditPlaceForm(
        @NotBlank(message = "{places.name.notempty}")
        @Size(max = 100, message = "{places.fields.size}")
        String name,
        @NotBlank(message = "{places.district.notempty}")
        @Size(max = 100, message = "{places.fields.size}")
        String district,
        @NotBlank(message = "{places.city.notempty}")
        @Size(max = 100, message = "{places.fields.size}")
        String city,
        @NotBlank(message = "{places.code.notempty}")
        @Pattern(regexp = "[a-z-]+", message = "{places.code.invalid.pattern}")
        String code) {

    public Places toEntity(){
        return new Places(name, district, city, code);
    }

}
