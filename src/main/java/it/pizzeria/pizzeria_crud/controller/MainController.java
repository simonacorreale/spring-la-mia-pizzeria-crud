
package it.pizzeria.pizzeria_crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pizzeria.pizzeria_crud.model.Pizza;

@Controller
@RequestMapping("/index")
public class MainController {

    @GetMapping
    public String index(Model model) {

        List<Pizza> pizze = new ArrayList<>();

        return "index";

    }

}
