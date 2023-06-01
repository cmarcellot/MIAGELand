package com.miage.miageland.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Visiteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String prenom;
    private String adresseMail;

    @OneToMany(mappedBy = "visiteur", cascade = CascadeType.ALL)
    private List<Billet> billets;

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

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }

    public void reserverBillet() {
        // Logique pour réserver un billet
    }

    public void payerBillet() {
        // Logique pour payer un billet
    }

    public void annulerBillet() {
        // Logique pour annuler un billet
    }

    public void consulterBillet() {
        // Logique pour consulter un billet
    }

    public void consulterAttractions() {
        // Logique pour consulter les attractions
    }
}
