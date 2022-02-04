package br.com.alura.dojoplaces.places;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlacesRepository extends JpaRepository<Places, Long> {
}
