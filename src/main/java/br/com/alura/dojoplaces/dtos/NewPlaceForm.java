package br.com.alura.dojoplaces.dtos;

import br.com.alura.dojoplaces.models.Place;

import javax.validation.constraints.*;

public class NewPlaceForm {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = "[a-z0-9-]+")
    private String code;

    @NotBlank
    @Size(max = 100)
    private String neighborhood;

    @NotBlank
    @Size(max = 100)
    private String city;

    public NewPlaceForm(String name, String code, String neighborhood, String city) {
        this.name = name;
        this.code = code;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public Place toModel() {
        return new Place(name, code, neighborhood, city);
    }

}
