package br.com.alura.dojoplaces.controllers;

import br.com.alura.dojoplaces.dtos.NewPlaceDTO;
import br.com.alura.dojoplaces.models.Place;
import br.com.alura.dojoplaces.repositories.PlaceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/local/novo")
    public String form(NewPlaceDTO newPlaceDTO) {
        return "/place/form";
    }

    @PostMapping("/local/novo")
    public String newPlace(@Valid NewPlaceDTO newPlaceDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/place/form";

        Place place = newPlaceDTO.toModel();
        placeRepository.save(place);

        return "redirect:/local/lista";
    }

    @GetMapping("/local/lista")
    public String list(Model model) {
        List<Place> places = placeRepository.findAll();
        model.addAttribute("places", places);
        return "/place/list";
    }
}
