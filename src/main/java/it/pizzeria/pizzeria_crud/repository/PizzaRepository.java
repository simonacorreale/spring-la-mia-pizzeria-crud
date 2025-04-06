package it.pizzeria.pizzeria_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.pizzeria_crud.model.Pizza;

// Lo scopo è estendere una jba repository 
// Tramite i Generics in questo caso viene applicato il suo oggetto di repository
// e il suo id 
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
