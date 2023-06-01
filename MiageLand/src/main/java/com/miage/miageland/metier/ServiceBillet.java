package com.miage.miageland.metier;

import com.miage.miageland.dao.BilletRepository;
import com.miage.miageland.entities.Billet;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Bean métier pour la gestion des billets
 */
@Service
public class ServiceBillet {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final BilletRepository billetRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param billetRepository le bean repository à injecter
     */
    public ServiceBillet(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }

    /**
     * Crée un nouveau billet
     * @param date la date du billet
     * @param numero le numéro du billet
     * @param prix le prix du billet
     * @param etat l'état du billet
     * @return le billet créé
     */
    public Billet creerBillet(Date date, String numero, float prix, String etat) {
        Billet billet = new Billet();
        billet.setDate(date);
        billet.setNumero(numero);
        billet.setPrix(prix);
        billet.setEtat(etat);
        return billetRepository.save(billet);
    }

    /**
     * Récupère un billet par son identifiant
     * @param id l'identifiant du billet
     * @return le billet correspondant
     */
    public Optional<Billet> recupererBillet(Long id) {
        return billetRepository.findById(id);
    }

    /**
     * Supprime un billet
     * @param billet le billet à supprimer
     */
    public void supprimerBillet(Billet billet) {
        billetRepository.delete(billet);
    }

    /**
     * Récupère la liste de tous les billets
     * @return la liste des billets
     */
    public List<Billet> obtenirTousLesBillets() {
        return (List<Billet>) billetRepository.findAll();
    }
}

