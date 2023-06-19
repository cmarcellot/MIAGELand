package com.miage.miageland.dao;

import com.miage.miageland.entities.Visiteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * DAO pour les entités représentant les visiteurs du parc d'attraction
 */
public interface VisiteurRepository extends CrudRepository<Visiteur, Long> {

    /**
     * Recherche des visiteurs par nom
     * @param nom le nom du visiteur
     * @return la liste des visiteurs qui correspondent
     */
    List<Visiteur> findByNom(String nom);

    /**
     * Recherche des visiteurs par prénom
     * @param prenom le prénom du visiteur
     * @return la liste des visiteurs qui correspondent
     */
    List<Visiteur> findByPrenom(String prenom);

    /**
     * Recherche des visiteurs par adresse e-mail
     * @param adresseMail l'adresse e-mail du visiteur
     * @return la liste des visiteurs qui correspondent
     */
    List<Visiteur> findByAdresseMail(String adresseMail);
}
