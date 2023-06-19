package com.miage.miageland.metier;

import com.miage.miageland.dao.EmployeRepository;
import com.miage.miageland.entities.Employe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Bean métier pour la gestion des employés
 */
@Service
public class ServiceEmploye {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final EmployeRepository employeRepository;

    /**
     * Constructeur pour l'injection du bean repository
     *
     * @param employeRepository le bean repository à injecter
     */
    public ServiceEmploye(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    /**
     * Crée un nouvel employé
     * @param nom le nom de l'employé
     * @param prenom le prénom de l'employé
     * @param adresseMail l'adresse e-mail de l'employé
     * @return l'employé créé
     */
    public Employe creerEmploye(String nom, String prenom, String adresseMail) {
        Employe employe = new Employe();
        employe.setNom(nom);
        employe.setPrenom(prenom);
        employe.setAdresseMail(adresseMail);
        return employeRepository.save(employe);
    }

    /**
     * Récupère un employé par son identifiant
     * @param id l'identifiant de l'employé
     * @return l'employé correspondant
     */
    public Optional<Employe> recupererEmploye(Long id) {
        return employeRepository.findById(String.valueOf(id));
    }

    /**
     * Supprime un employé
     * @param id l'identifiant de l'employé à supprimer
     */
    public void supprimerEmploye(Long id) {
        employeRepository.deleteById(String.valueOf(id));
    }

    /**
     * Récupère la liste de tous les employés
     * @return la liste des employés
     */
    public List<Employe> obtenirTousLesEmployes() {
        return (List<Employe>) employeRepository.findAll();
    }
}
