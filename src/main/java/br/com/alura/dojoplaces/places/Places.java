package br.com.alura.dojoplaces.places;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{places.name.notempty}")
    @Size(max = 100, message = "{places.fields.size}")
    private String name;
    @NotBlank(message = "{places.district.notempty}")
    @Size(max = 100, message = "{places.fields.size}")
    private String district;
    @NotBlank(message = "{places.city.notempty}")
    @Size(max = 100, message = "{places.fields.size}")
    private String city;
    @NotBlank(message = "{places.code.notempty}")
    @Pattern(regexp = "[a-z-]+", message = "{places.code.invalid.pattern}")
    private String code;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
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

    public void toMerge(EditPlaceForm form){
        this.name = form.name();
        this.district = form.district();
        this.city = form.city();
        this.code = form.code();
        this.updatedAt = LocalDateTime.now();
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
