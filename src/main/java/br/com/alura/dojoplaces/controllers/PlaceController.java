package br.com.alura.dojoplaces.controllers;

import br.com.alura.dojoplaces.dtos.*;
import br.com.alura.dojoplaces.exceptions.NotFoundException;
import br.com.alura.dojoplaces.models.Place;
import br.com.alura.dojoplaces.repositories.PlaceRepository;
import br.com.alura.dojoplaces.validations.EditPlaceFormValidator;
import br.com.alura.dojoplaces.validations.NewPlaceFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @InitBinder("newPlaceForm")
    public void initBinderNewPlaceForm(WebDataBinder binder) {
        binder.addValidators(new NewPlaceFormValidator(placeRepository));
    }

    @InitBinder("editPlaceForm")
    public void initBinderEditPlaceForm(WebDataBinder binder) {
        binder.addValidators(new EditPlaceFormValidator(placeRepository));
    }

    @GetMapping("/local/novo")
    public String form(NewPlaceForm newPlaceForm, Model model) {
        return "/place/newForm";
    }

    @PostMapping("/local/novo")
    public String newPlace(@Valid NewPlaceForm newPlaceForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/place/newForm";

        Place place = newPlaceForm.toModel();
        placeRepository.save(place);

        return "redirect:/local/lista";
    }

    @GetMapping("/local/lista")
    public String list(Model model) {
        List<PlaceView> places = placeRepository.findAll().stream().map(PlaceView::new).toList();
        model.addAttribute("places", places);
        return "/place/list";
    }

    @GetMapping("/local/editar/{id}")
    public String formEdit(@PathVariable("id") Long id, Model model) {
        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("editPlaceForm", new EditPlaceForm(place));
        return "/place/editForm";
    }

    @PostMapping("/local/editar")
    public String editPlace(@Valid EditPlaceForm editPlaceForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "/place/editForm";

        Place place = placeRepository.findById(editPlaceForm.getId()).orElseThrow(NotFoundException::new);
        place.merge(editPlaceForm);
        placeRepository.save(place);

        return "redirect:/local/lista";
    }

    @GetMapping("/local/remover/{id}")
    public String removePlace(@PathVariable("id") Long id) {
        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        placeRepository.delete(place);
        return "redirect:/local/lista";
    }
}
