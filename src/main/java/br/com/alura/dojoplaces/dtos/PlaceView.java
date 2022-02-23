package br.com.alura.dojoplaces.dtos;

import br.com.alura.dojoplaces.models.Place;
import br.com.alura.dojoplaces.utils.DaysUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlaceView {

    private Long id;
    private String name;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PlaceView(Place place) {
        this.id = place.getId();
        this.name = place.getName();
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

    public String getCode() {
        return code;
    }

    public String getCreatedAtFormatted() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(createdAt);
    }

    public String getDaysSinceLastUpdate() {
        return DaysUtil.between(createdAt.toLocalDate(), updatedAt.toLocalDate());
    }
}
