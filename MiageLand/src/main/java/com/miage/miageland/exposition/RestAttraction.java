package com.miage.miageland.exposition;

import com.miage.miageland.entities.Attraction;
import com.miage.miageland.metier.ServiceAttraction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
public class RestAttraction {

    private final ServiceAttraction serviceAttraction;

    public RestAttraction(ServiceAttraction serviceAttraction) {
        this.serviceAttraction = serviceAttraction;
    }

    /**
     * Récupère les détails d'une attraction
     * GET sur http://localhost:8080/api/attractions/1
     * @param idAttraction l'ID de l'attraction
     * @return l'attraction en JSON
     */
    @GetMapping("/{id}")
    public Attraction getAttraction(@PathVariable("id") Long idAttraction) {
        return serviceAttraction.recupererAttraction(idAttraction).orElse(null);
    }

    /**
     * Crée une nouvelle attraction
     * POST sur http://localhost:8080/api/attractions
     * @param attraction les détails de l'attraction envoyés par le front
     * @return la nouvelle attraction en JSON
     */
    @PostMapping
    public Attraction createAttraction(@RequestBody Attraction attraction) {
        return serviceAttraction.creerAttraction(attraction.getNom(), attraction.isEstOuverte());
    }

    /**
     * Supprime une attraction
     * DELETE sur http://localhost:8080/api/attractions/1
     * @param idAttraction l'ID de l'attraction à supprimer
     * @return un message de confirmation de la suppression
     */
    @DeleteMapping("/{id}")
    public String deleteAttraction(@PathVariable("id") Long idAttraction) {
        serviceAttraction.supprimerAttraction(idAttraction);
        return "Attraction supprimée avec succès.";
    }

    /**
     * Récupère la liste de toutes les attractions
     * GET sur http://localhost:8080/api/attractions
     * @return la liste des attractions en JSON
     */
    @GetMapping
    public List<Attraction> getAllAttractions() {
        return serviceAttraction.obtenirToutesLesAttractions();
    }

}