package com.miage.miageland.dao;

import com.miage.miageland.entities.Administrateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DAO pour les entités représentant les administrateurs du parc d'attraction
 */
public interface AdministrateurRepository extends CrudRepository<Administrateur, String> {

    /**
     * Recherche des administrateurs par nom
     * @param nom le nom de l'administrateur
     * @return la liste des administrateurs qui correspondent
     */
    List<Administrateur> findByNom(String nom);

    /**
     * Recherche des administrateurs par prénom
     * @param prenom le prénom de l'administrateur
     * @return la liste des administrateurs qui correspondent
     */
    List<Administrateur> findByPrenom(String prenom);

    /**
     * Recherche des administrateurs par adresse e-mail
     * @param adresseMail l'adresse e-mail de l'administrateur
     * @return la liste des administrateurs qui correspondent
     */
    List<Administrateur> findByAdresseMail(String adresseMail);

    /**
     * Recherche des administrateurs par nom et prénom
     * @param nom le nom de l'administrateur
     * @param prenom le prénom de l'administrateur
     * @return la liste des administrateurs qui correspondent
     */
    List<Administrateur> findByNomAndPrenom(String nom, String prenom);

}

