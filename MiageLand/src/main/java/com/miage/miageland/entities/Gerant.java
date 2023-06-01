package com.miage.miageland.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gerant {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String adresseMail;

    public void ajouterAttraction(Attraction attraction) {
        // Code pour ajouter une attraction
    }

    public void supprimerAttraction(Attraction attraction) {
        // Code pour supprimer une attraction
    }

    public void ouvrirAttraction(Attraction attraction) {
        // Code pour ouvrir une attraction
    }

    public void fermerAttraction(Attraction attraction) {
        // Code pour fermer une attraction
    }

    public void creerCompteEmploye() {
        // Code pour créer un compte employé
    }

    public void supprimerCompteEmploye(Employe employe) {
        // Code pour supprimer un compte employé
    }

    public void consulterVentes() {
        // Code pour consulter les ventes
    }

    public void instaurerJauges() {
        // Code pour instaurer les jauges
    }
}
