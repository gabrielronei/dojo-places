package br.com.alura.dojoplaces.places;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @GetMapping("/oi")
    public String oi() {
        return "/oi";
    }
}
