package br.com.alura.dojoplaces.places;

import java.time.LocalDateTime;

public class PlaceDTO {

    private Long id;
    private String name;
    private String district;
    private String city;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PlaceDTO(Places place) {
        this.id = place.getId();
        this.name = place.getName();
        this.district = place.getDistrict();
        this.city = place.getCity();
        this.code = place.getCode();
        this.createdAt = place.getCreatedAt();
        this.updatedAt = place.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
