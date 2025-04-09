
package it.pizzeria.pizzeria_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pizzeria.pizzeria_crud.model.Pizza;
import it.pizzeria.pizzeria_crud.repository.PizzaRepository;

@Controller
@RequestMapping("/index")
public class MainController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {

        List<Pizza> result = pizzaRepository.findAll();
        model.addAttribute("list", result);

        return "/pizza/index";

    }

}
