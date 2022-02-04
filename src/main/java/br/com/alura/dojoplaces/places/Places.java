package br.com.alura.dojoplaces.places;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não poder ser vazio ou nulo")
    @Size(max = 100)
    private String name;

    private String district;
    private String city;
    private String code;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Deprecated
    public Places() {
    }

    public Places(String name, String district, String city, String code) {
        this.name = name;
        this.district = district;
        this.city = city;
        this.code = code;
        this.createdAt = LocalDateTime.now();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }
}
