package br.com.alura.dojoplaces.places;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/local")
public class PlacesController {

    private PlacesRepository placesRepository;

    public PlacesController(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @GetMapping("/places")
    public String findAll(){
        return "newPlace";
    }

    @PostMapping("/places")
    public String insertPlace(NewPlaceForm newPlaceForm, Model model){
        Places place = newPlaceForm.toEntity();
        placesRepository.save(place);
        model.addAttribute("place", place);
        return "viewPlace";
    }

}
