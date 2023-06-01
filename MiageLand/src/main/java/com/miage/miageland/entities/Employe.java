package com.miage.miageland.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String nom;

    private String prenom;

    private String adresseMail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

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

