package br.com.alura.dojoplaces.dtos;

import br.com.alura.dojoplaces.models.Place;

public class PlaceForm {

    private Long id;
    private String name;
    private String code;
    private String neighborhood;
    private String city;

    public PlaceForm(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.code = place.getCode();
        this.neighborhood = place.getNeighborhood();
        this.city = place.getCity();
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
