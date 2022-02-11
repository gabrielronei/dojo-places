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

    public EditPlaceForm(Long id, String name, String code, String neighborhood, String city) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public Long getId() {
        return id;
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

}
