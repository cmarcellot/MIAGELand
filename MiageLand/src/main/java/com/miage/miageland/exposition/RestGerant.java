package com.miage.miageland.exposition;

import com.miage.miageland.entities.Gerant;
import com.miage.miageland.metier.ServiceGerant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createGerant(@RequestBody Gerant gerant) {
        serviceGerant.creerGerant(gerant.getNom(), gerant.getPrenom(), gerant.getAdresseMail());
        return ResponseEntity.ok("Le gérant " + gerant.getPrenom() + " " + gerant.getNom() + " a été créé avec succès.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGerant(@PathVariable("id") Long id) {
        Gerant gerant = serviceGerant.recupererGerant(String.valueOf(id)).orElse(null);
        if (gerant != null) {
            serviceGerant.supprimerGerant(id);
            return ResponseEntity.ok("Le gérant " + gerant.getPrenom() + " " + gerant.getNom() + " (ID: " + id + ") a été supprimé avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping
    public List<Gerant> getAllGerants() {
        return serviceGerant.obtenirTousLesGerants();
    }*/

    @GetMapping("/{id}/jauge")
    public ResponseEntity<String> getJaugeGerant(@PathVariable("id") Long id) {
        return ResponseEntity.ok("La jauge du parc est de " + serviceGerant.getJaugeGerant(id) + " visiteurs.");
    }

    @PutMapping("/{id}/jauge")
    public ResponseEntity<String> modifierJaugeGerant(@PathVariable("id") Long id, @RequestParam("jauge") int nouvelleJauge) {
        Gerant gerant = serviceGerant.recupererGerant(String.valueOf(id)).orElse(null);
        if (gerant != null) {
            int ancienneJauge = serviceGerant.getJaugeGerant(id);
            serviceGerant.modifierJaugeGerant(id, nouvelleJauge);
            return ResponseEntity.ok("La jauge du parc a été modifiée avec succès. Ancienne jauge : " + ancienneJauge + " visiteurs, Nouvelle jauge : " + nouvelleJauge + " visiteurs.");
        } else {
            return ResponseEntity.notFound().build();
        }    }
}
