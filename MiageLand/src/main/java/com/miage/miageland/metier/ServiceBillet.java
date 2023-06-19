package com.miage.miageland.metier;

import com.miage.miageland.dao.BilletRepository;
import com.miage.miageland.dao.VisiteurRepository;
import com.miage.miageland.entities.Billet;
import com.miage.miageland.entities.EtatBillet;
import com.miage.miageland.utilities.BilletInexistantException;
import com.miage.miageland.utilities.BilletNonAnnulableException;
import com.miage.miageland.utilities.EtatBilletInexistantException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Bean métier pour la gestion des billets
 */
@Service
public class ServiceBillet {
    /**
     * Bean repository, pour les billets, qui sera injecté par le constructeur
     */
    private final BilletRepository billetRepository;
    /**
     * Bean repository, pour les Visiteurs, qui sera injecté par le constructeur
     */
    private final VisiteurRepository visiteurRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param billetRepository le bean repository à injecter
     */
    public ServiceBillet(BilletRepository billetRepository, VisiteurRepository visiteurRepository) {
        this.billetRepository = billetRepository;
        this.visiteurRepository = visiteurRepository;
    }

    /**
     * Crée un nouveau billet
     *
     * @param date       la date du billet
     * @param prix       le prix du billet
     * @param idVisiteur l'ID du visiteur
     * @return le billet créé
     */
    public Billet creerBillet(Date date, float prix, Long idVisiteur) {
        Billet billet = new Billet();
        billet.setDate(date);
        billet.setPrix(prix);
        billet.setEtat(EtatBillet.RESERVE);
        billet.setVisiteur(visiteurRepository.findById(idVisiteur).orElse(null));
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

    /**
     * Modifie l'état d'un billet
     * @param idBillet l'ID du billet à modifié
     * @param etatModifie l'etat du billet modifié
     * @return le billet modifié
     * @throws BilletInexistantException si le billet n'existe pas
     * @throws BilletNonAnnulableException si le délai de 7 jours est dépassé
     * @throws EtatBilletInexistantException si l'état du billety n'existe pas
     */
    public ResponseEntity<String> modifierEtatBillet(Long idBillet, String etatModifie) throws BilletInexistantException, BilletNonAnnulableException {
        Optional<Billet> optionalBillet = billetRepository.findById(idBillet);
        if (optionalBillet.isEmpty()) {
            throw new BilletInexistantException("Le billet d'ID " + idBillet + " n'existe pas.");
        }

        Billet billet = optionalBillet.get();

        if (etatModifie.equals("Annulé")){
            Date dateAujourdhui = new Date();
            long differenceEnJours = TimeUnit.DAYS.convert(dateAujourdhui.getTime() - billet.getDate().getTime(), TimeUnit.MILLISECONDS);

            if (differenceEnJours <= 7) {
                System.out.println("Ici");
                billet.setEtat(EtatBillet.ANNULE);
                billetRepository.save(billet);
                return new ResponseEntity<> ("Le billet d'ID " + billet.getId() + " est bien annulé, vous serez remboursé de " + billet.getPrix() + "€", HttpStatus.OK);
                //TODO: Envoyer un mail à l'utilisateur pour lui dire que son billet a été annulé
            } else {
                throw new BilletNonAnnulableException("Le délai de 7 jours pour annuler le billet est dépassé.");
            }
        } else if(etatModifie.equals("Payé")) {
            billet.setEtat(EtatBillet.PAYE);
            billetRepository.save(billet);
            return new ResponseEntity<>("Le billet d'ID " + billet.getId() +  " a bien été payé.", HttpStatus.OK);
        } else {
            throw new EtatBilletInexistantException("L'état du billet " + etatModifie + " n'existe pas.");
        }
    }
}

