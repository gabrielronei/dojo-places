package br.com.alura.dojoplaces.repositories;

import br.com.alura.dojoplaces.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
