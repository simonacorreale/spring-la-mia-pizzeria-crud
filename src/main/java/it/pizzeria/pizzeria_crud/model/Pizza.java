package it.pizzeria.pizzeria_crud.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* Una pizza avrà le seguenti informazioni :
- un nome
- una descrizione
- una foto (url)
- un prezzo
@Entity */

@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomePizza;

    private String descrizione;

    private String foto;

    private double prezzo;

}
