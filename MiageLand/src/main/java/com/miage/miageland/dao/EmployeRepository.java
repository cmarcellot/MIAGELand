package com.miage.miageland.dao;

import com.miage.miageland.entities.Employe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DAO pour les entités représentant les employés du parc d'attraction
 */
public interface EmployeRepository extends CrudRepository<Employe, String> {

    /**
     * Recherche des employés par nom
     * @param nom le nom de l'employé
     * @return la liste des employés qui correspondent
     */
    List<Employe> findByNom(String nom);

    /**
     * Recherche des employés par prénom
     * @param prenom le prénom de l'employé
     * @return la liste des employés qui correspondent
     */
    List<Employe> findByPrenom(String prenom);

    /**
     * Recherche des employés par adresse e-mail
     * @param adresseMail l'adresse e-mail de l'employé
     * @return la liste des employés qui correspondent
     */
    List<Employe> findByAdresseMail(String adresseMail);

    /**
     * Recherche des employés par nom et prénom
     * @param nom le nom de l'employé
     * @param prenom le prénom de l'employé
     * @return la liste des employés qui correspondent
     */
    List<Employe> findByNomAndPrenom(String nom, String prenom);

}

