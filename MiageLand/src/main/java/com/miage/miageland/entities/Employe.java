package com.miage.miageland.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Getter
@Setter
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String nom;

    private String prenom;

    private String adresseMail;

    public void seConnecter() {
        // Code pour la connexion
    }

    public void seDeconnecter() {
        // Code pour la déconnexion
    }

    public void scannerBillet() {
        // Code pour scanner un billet
    }
}
