package com.miage.miageland.metier;

import com.miage.miageland.dao.AdministrateurRepository;
import com.miage.miageland.entities.Administrateur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Bean métier pour la gestion des administrateurs
 */
@Service
public class ServiceAdministrateur {

    private final AdministrateurRepository administrateurRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param administrateurRepository le bean repository à injecter
     */
    public ServiceAdministrateur(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    /**
     * Crée un nouvel administrateur
     * @param nom le nom de l'administrateur
     * @param prenom le prénom de l'administrateur
     * @param adresseMail l'adresse e-mail de l'administrateur
     * @return l'administrateur créé
     */
    public Administrateur creerAdministrateur(String nom, String prenom, String adresseMail) {
        Administrateur administrateur = new Administrateur();
        administrateur.setNom(nom);
        administrateur.setPrenom(prenom);
        administrateur.setAdresseMail(adresseMail);
        return administrateurRepository.save(administrateur);
    }

    /**
     * Récupère un administrateur par son identifiant
     * @param id l'identifiant de l'administrateur
     * @return l'administrateur correspondant
     */
    public Optional<Administrateur> recupererAdministrateur(String id) {
        return administrateurRepository.findById(id);
    }

    /**
     * Supprime un administrateur
     * @param administrateur l'administrateur à supprimer
     */
    public void supprimerAdministrateur(Long administrateur) {
        administrateurRepository.deleteById(String.valueOf(administrateur));
    }

    /**
     * Récupère la liste de tous les administrateurs
     * @return la liste des administrateurs
     */
    public List<Administrateur> obtenirTousLesAdministrateurs() {
        return (List<Administrateur>) administrateurRepository.findAll();
    }
}
