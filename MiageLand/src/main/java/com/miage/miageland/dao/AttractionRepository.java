package com.miage.miageland.dao;

import com.miage.miageland.entities.Attraction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DAO pour les entités représentant les attractions du parc d'attraction
 */
public interface AttractionRepository extends CrudRepository<Attraction, Long> {

    /**
     * Recherche des attractions par nom
     * @param nom le nom de l'attraction
     * @return la liste des attractions qui correspondent
     */
    List<Attraction> findByNom(String nom);

    /**
     * Recherche des attractions ouvertes
     * @return la liste des attractions ouvertes
     */
    List<Attraction> findByEstOuverteTrue();

    /**
     * Recherche des attractions fermées
     * @return la liste des attractions fermées
     */
    List<Attraction> findByEstOuverteFalse();

}

