package com.miage.miageland.metier;

import com.miage.miageland.dao.VisiteurRepository;
import com.miage.miageland.entities.Visiteur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Bean métier pour la gestion des visiteurs
 */
@Service
public class ServiceVisiteur {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final VisiteurRepository visiteurRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param visiteurRepository le bean repository à injecter
     */
    public ServiceVisiteur(VisiteurRepository visiteurRepository) {
        this.visiteurRepository = visiteurRepository;
    }

    /**
     * Crée un nouveau visiteur
     * @param nom le nom du visiteur
     * @param prenom le prénom du visiteur
     * @param adresseMail l'adresse e-mail du visiteur
     * @return le visiteur créé
     */
    public Visiteur creerVisiteur(String nom, String prenom, String adresseMail) {
        Visiteur visiteur = new Visiteur();
        visiteur.setNom(nom);
        visiteur.setPrenom(prenom);
        visiteur.setAdresseMail(adresseMail);
        return visiteurRepository.save(visiteur);
    }

    /**
     * Récupère un visiteur par son identifiant
     * @param id l'identifiant du visiteur
     * @return le visiteur correspondant
     */
    public Optional<Visiteur> recupererVisiteur(Long id) {
        return visiteurRepository.findById(id);
    }

    /**
     * Supprime un visiteur
     * @param idVisiteur l'identifiant du visiteur à supprimer
     */
    public void supprimerVisiteur(Long idVisiteur) {
        visiteurRepository.deleteById(idVisiteur);
    }

    /**
     * Récupère la liste de tous les visiteurs
     * @return la liste des visiteurs
     */
    public List<Visiteur> obtenirTousLesVisiteurs() {
        return (List<Visiteur>) visiteurRepository.findAll();
    }
}
