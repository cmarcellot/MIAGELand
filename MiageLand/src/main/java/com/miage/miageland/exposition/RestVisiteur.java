package com.miage.miageland.exposition;

import com.miage.miageland.entities.Visiteur;
import com.miage.miageland.metier.ServiceVisiteur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visiteurs")
public class RestVisiteur {

    private final ServiceVisiteur serviceVisiteur;

    public RestVisiteur(ServiceVisiteur serviceVisiteur) {
        this.serviceVisiteur = serviceVisiteur;
    }

    /**
     * Récupère les informations d'un visiteur par son ID
     * GET sur http://localhost:8080/api/visiteurs/{id}
     *
     * @param idVisiteur l'ID du visiteur
     * @return le visiteur correspondant en JSON
     */
    @GetMapping("/{id}")
    public Visiteur getVisiteur(@PathVariable("id") Long idVisiteur) {
        return serviceVisiteur.recupererVisiteur(idVisiteur).orElse(null);
    }

    /**
     * Crée un nouveau visiteur
     * POST sur http://localhost:8080/api/visiteurs
     *
     * @param visiteur les détails du visiteur envoyés par le front
     * @return le nouveau visiteur en JSON
     */
    @PostMapping
    public Visiteur creerVisiteur(@RequestBody Visiteur visiteur) {
        return serviceVisiteur.creerVisiteur(visiteur.getNom(), visiteur.getPrenom(), visiteur.getAdresseMail());
    }

    /**
     * Supprime un visiteur par son ID
     * DELETE sur http://localhost:8080/api/visiteurs/{id}
     *
     * @param idVisiteur l'ID du visiteur à supprimer
     * @return une confirmation de la suppression
     */
    @DeleteMapping("/{id}")
    public String supprimerVisiteur(@PathVariable("id") Long idVisiteur) {
        serviceVisiteur.supprimerVisiteur(idVisiteur);
        return "Le visiteur d'ID " + idVisiteur + " a été supprimé avec succès.";
    }

    /**
     * Récupère la liste des visiteurs
     * GET sur http://localhost:8080/api/visiteurs
     *
     * @return la liste des visiteurs en JSON
     */
    @GetMapping
    public List<Visiteur> listerVisiteurs() {
        return serviceVisiteur.obtenirTousLesVisiteurs();
    }
}

