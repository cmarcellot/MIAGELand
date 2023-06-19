package com.miage.miageland.exposition;

import com.miage.miageland.entities.Gerant;
import com.miage.miageland.metier.ServiceGerant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gerants")
public class RestGerant {

    private final ServiceGerant serviceGerant;

    public RestGerant(ServiceGerant serviceGerant) {
        this.serviceGerant = serviceGerant;
    }

    @GetMapping("/{id}")
    public Gerant getGerant(@PathVariable("id") Long id) {
        return serviceGerant.recupererGerant(String.valueOf(id)).orElse(null);
    }

    @PostMapping
    public Gerant createGerant(@RequestBody Gerant gerant) {
        return serviceGerant.creerGerant(gerant.getNom(), gerant.getPrenom(), gerant.getAdresseMail());
    }

    @DeleteMapping("/{id}")
    public String deleteGerant(@PathVariable("id") Long id) {
        serviceGerant.supprimerGerant(id);
        return "Le gérant d'ID " + id + " a été supprimé avec succès.";
    }

    @GetMapping
    public List<Gerant> getAllGerants() {
        return serviceGerant.obtenirTousLesGerants();
    }
}
