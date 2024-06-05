package br.com.alura.dojoplaces.models;

import br.com.alura.dojoplaces.dtos.EditPlaceForm;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "[a-z0-9-]+$")
    private String code;

    @NotBlank
    @Size(max = 100)
    private String neighborhood;

    @NotBlank
    @Size(max = 100)
    private String city;

    @Deprecated
    public Place() {

    }

    public Place(String name, String code, String neighborhood, String city) {
        this.name = name;
        this.code = code;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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

    public Place merge(EditPlaceForm editPlaceForm) {
        this.name = editPlaceForm.getName();
        this.code = editPlaceForm.getCode();
        this.neighborhood = editPlaceForm.getNeighborhood();
        this.city = editPlaceForm.getCity();
        return this;
    }

}
