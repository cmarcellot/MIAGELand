package com.miage.miageland.metier;

import com.miage.miageland.dao.AttractionRepository;
import com.miage.miageland.entities.Attraction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Bean métier pour la gestion des attractions
 */
@Service
public class ServiceAttraction {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final AttractionRepository attractionRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param attractionRepository le bean repository à injecter
     */
    public ServiceAttraction(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    /**
     * Crée une nouvelle attraction
     * @param nom le nom de l'attraction
     * @param estOuverte l'état d'ouverture de l'attraction
     * @return l'attraction créée
     */
    public Attraction creerAttraction(String nom, boolean estOuverte) {
        Attraction attraction = new Attraction();
        attraction.setNom(nom);
        attraction.setEstOuverte(estOuverte);
        return attractionRepository.save(attraction);
    }

    /**
     * Récupère une attraction par son identifiant
     * @param id l'identifiant de l'attraction
     * @return l'attraction correspondante
     */
    public Optional<Attraction> recupererAttraction(Long id) {
        return attractionRepository.findById(id);
    }

    /**
     * Supprime une attraction
     * @param attraction l'attraction à supprimer
     */
    public void supprimerAttraction(Long attraction) {
        attractionRepository.deleteById(attraction);
    }

    /**
     * Récupère la liste de toutes les attractions
     * @return la liste des attractions
     */
    public List<Attraction> obtenirToutesLesAttractions() {
        return (List<Attraction>) attractionRepository.findAll();
    }
}
