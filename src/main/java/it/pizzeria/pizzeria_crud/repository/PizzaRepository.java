package it.pizzeria.pizzeria_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.pizzeria_crud.model.Pizza;

//_______
// List<Pizza> --> ho creato la classe pizza --> creiamo la repo della tabella pizza chiamata
// "pizza repository".
//_______
// Lo scopo è estendere una jba repository 
// Tramite i Generics in questo caso viene applicato il suo oggetto di repository
// e il suo id, quella che è definita è una interfaccia e qui dove si definiscono
// le query per la tabella in questo caso la pizza richiama la sua collection list
//_______
// JPA è uno strato applicativo che si frppone tra il model e il controller
//_______
// Ogni tabella ha bisogno del suo JPA correlato
// 1 Un oggetto che mappa la tabella e il JPA per le query
// Come utilizziamo il repository nel controller? (Tramite la Dependency Injection - semplicemente si crea una dipendenza)
// JPA si comporta come quindi l'interfaccia per esempio "pizza repositpry" potrà essere utilizzata nel contesto di spring
// Bookrepository stacca la sua dipendenza passando il controllo (IoC) a JPR repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
