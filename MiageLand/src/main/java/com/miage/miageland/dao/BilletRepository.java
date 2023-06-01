package com.miage.miageland.dao;

import com.miage.miageland.entities.Billet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DAO pour les entités représentant les billets du parc d'attraction
 */
public interface BilletRepository extends CrudRepository<Billet, Long> {

    /**
     * Recherche des billets par numéro
     * @param numero le numéro du billet
     * @return la liste des billets qui correspondent
     */
    List<Billet> findByNumero(String numero);

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

}
