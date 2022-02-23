package br.com.alura.dojoplaces.dtos;

import br.com.alura.dojoplaces.models.Place;

import javax.validation.constraints.*;

public class EditPlaceForm {

    @NotNull
    private Long id;

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

    public EditPlaceForm() {

    }

    public EditPlaceForm(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.code = place.getCode();
        this.neighborhood = place.getNeighborhood();
        this.city = place.getCity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
