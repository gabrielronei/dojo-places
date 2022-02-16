package br.com.alura.dojoplaces.places;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/local")
public class PlacesController {

    private PlacesRepository placesRepository;

    public PlacesController(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @GetMapping("/places")
    public String findAll(Model model){
        List<Places> places = placesRepository.findAll();
        model.addAttribute("places", places);
        return "places/viewPlace";
    }

    @GetMapping("places/new")
    public String showform(Model model){
        return "places/newPlace";
    }

    @PostMapping("/places")
    public String insertPlace(@Valid NewPlaceForm newPlaceForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return showform(model);
        }

        Places place = newPlaceForm.toEntity();
        placesRepository.save(place);
        findAll(model);
        return "places/viewPlace";
    }

    @GetMapping("/places/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Places place = placesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id.toString()));
        model.addAttribute("place", new PlaceDTO(place));
        return "places/editPlace";
    }

    @Transactional
    @PostMapping("/places/edit/{id}")
    public String edit(@PathVariable Long id, @Valid EditPlaceForm editPlaceForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showEditForm(id, model);
        }
        Places place = placesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id.toString()));
        place.toMerge(editPlaceForm);
        return "redirect:/local/places";
    }

}
