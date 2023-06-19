package com.miage.miageland.entities;

public enum EtatBillet {
    RESERVE("Réservé"),
    PAYE("Payé"),
    ANNULE("Annulé");

    private final String libelle;

    EtatBillet(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
