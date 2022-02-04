package br.com.alura.dojoplaces.places;

public record NewPlaceForm(String name, String district, String city, String code) {

    public Places toEntity(){
        return new Places(name, district, city, code);
    }

}
