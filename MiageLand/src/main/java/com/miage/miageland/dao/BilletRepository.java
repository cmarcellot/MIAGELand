package com.miage.miageland.dao;

import com.miage.miageland.entities.Billet;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * DAO pour les entités représentant les billets du parc d'attraction
 */
public interface BilletRepository extends CrudRepository<Billet, Long> {

    /**
     * Recherche des billets par état
     * @param etat l'état du billet
     * @return la liste des billets qui correspondent
     */
    List<Billet> findByEtat(String etat);

    /**
     * Recherche des billets par visiteur
     * @param visiteurId l'identifiant du visiteur
     * @return la liste des billets qui correspondent
     */
    List<Billet> findByVisiteurId(Long visiteurId);

    /**
     * Recherche des billets par date et état
     * @param date la date du billet
     * @param etat l'état du billet
     * @return la liste des billets qui correspondent
     */
    List<Billet> findByDateAndEtat(Date date, String etat);

    /**
     * Recherche des billets par date
     * @param date la date du billet
     * @return la liste des billets qui correspondent
     */
    List<Billet> findByDate(Date date);

}
