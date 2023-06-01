package com.miage.miageland.entities;

import jakarta.persistence.*;

@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private boolean estOuverte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEstOuverte() {
        return estOuverte;
    }

    public void setEstOuverte(boolean estOuverte) {
        this.estOuverte = estOuverte;
    }
}

