
package it.pizzeria.pizzeria_crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pizzeria.pizzeria_crud.model.Pizza;
import it.pizzeria.pizzeria_crud.repository.PizzaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/index")
public class MainController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model, @RequestParam(name = "keyword", required = false) String nomePizza) {

        List<Pizza> result;

        if (nomePizza != null && !nomePizza.isBlank()) {
            result = pizzaRepository.findByNomePizzaContainingIgnoreCase(nomePizza);
        } else {
            result = pizzaRepository.findAll();
        }

        model.addAttribute("list", result);
        model.addAttribute("keyword", nomePizza);

        return "pizza/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Optional<Pizza> optPizza = pizzaRepository.findById(id);

        if (optPizza.isPresent()) {
            model.addAttribute("pizza", optPizza.get());
            return "pizza/show";
        } else {
            model.addAttribute("errorCause", "Pizza non esiste nessuna pizza con questo id: " + id);
            return "error/404"; // NOTA: niente redirect qui!
        }

    }

    // Get per creare le pizze
    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("pizza", new Pizza());

        return "pizza/create";
    }

    // Post per la richiesta
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        // doc per errori
        // https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#all-errors
        if (bindingResult.hasErrors()) {
            return "pizza/create";
        }

        pizzaRepository.save(formPizza);
        return "redirect:/index";

    }

}
