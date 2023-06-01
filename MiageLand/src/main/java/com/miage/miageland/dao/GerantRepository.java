package com.miage.miageland.dao;

import com.miage.miageland.entities.Gerant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DAO pour les entités représentant les gérants du parc d'attraction
 */
public interface GerantRepository extends CrudRepository<Gerant, String> {

    /**
     * Recherche des gérants par nom
     * @param nom le nom du gérant
     * @return la liste des gérants qui correspondent
     */
    List<Gerant> findByNom(String nom);

    /**
     * Recherche des gérants par prénom
     * @param prenom le prénom du gérant
     * @return la liste des gérants qui correspondent
     */
    List<Gerant> findByPrenom(String prenom);

    /**
     * Recherche des gérants par adresse e-mail
     * @param adresseMail l'adresse e-mail du gérant
     * @return la liste des gérants qui correspondent
     */
    List<Gerant> findByAdresseMail(String adresseMail);

    /**
     * Recherche des gérants par nom et prénom
     * @param nom le nom du gérant
     * @param prenom le prénom du gérant
     * @return la liste des gérants qui correspondent
     */
    List<Gerant> findByNomAndPrenom(String nom, String prenom);

}

