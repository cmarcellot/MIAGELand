package com.miage.miageland.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("administrateur")
@Data
@NoArgsConstructor
public class Administrateur extends Employe {

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
}


