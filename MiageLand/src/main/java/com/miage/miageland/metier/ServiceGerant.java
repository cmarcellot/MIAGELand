package com.miage.miageland.metier;

import com.miage.miageland.dao.GerantRepository;
import com.miage.miageland.entities.Gerant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Bean métier pour la gestion des gérants
 */
@Service
public class ServiceGerant {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final GerantRepository gerantRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param gerantRepository le bean repository à injecter
     */
    public ServiceGerant(GerantRepository gerantRepository) {
        this.gerantRepository = gerantRepository;
    }

    /**
     * Crée un nouveau gérant
     * @param nom le nom du gérant
     * @param prenom le prénom du gérant
     * @param adresseMail l'adresse e-mail du gérant
     * @return le gérant créé
     */
    public Gerant creerGerant(String nom, String prenom, String adresseMail) {
        Gerant gerant = new Gerant();
        gerant.setNom(nom);
        gerant.setPrenom(prenom);
        gerant.setAdresseMail(adresseMail);
        return gerantRepository.save(gerant);
    }

    /**
     * Récupère un gérant par son identifiant
     * @param id l'identifiant du gérant
     * @return le gérant correspondant
     */
    public Optional<Gerant> recupererGerant(String id) {
        return gerantRepository.findById(id);
    }

    /**
     * Supprime un gérant
     * @param gerant le gérant à supprimer
     */
    public void supprimerGerant(Long gerant) {
        gerantRepository.deleteById(String.valueOf(gerant));
    }

    /**
     * Récupère la liste de tous les gérants
     * @return la liste des gérants
     */
    public List<Gerant> obtenirTousLesGerants() {
        return (List<Gerant>) gerantRepository.findAll();
    }
}
