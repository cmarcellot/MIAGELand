package com.miage.miageland.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Gerant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
