package com.miage.miageland.exposition;

import com.miage.miageland.entities.Administrateur;
import com.miage.miageland.metier.ServiceAdministrateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrateurs")
public class RestAdministrateur {

    private final ServiceAdministrateur serviceAdministrateur;

    public RestAdministrateur(ServiceAdministrateur serviceAdministrateur) {
        this.serviceAdministrateur = serviceAdministrateur;
    }

    @GetMapping("/{id}")
    public Administrateur getAdministrateur(@PathVariable("id") Long id) {
        return serviceAdministrateur.recupererAdministrateur(String.valueOf(id)).orElse(null);
    }

    @PostMapping
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return serviceAdministrateur.creerAdministrateur(administrateur.getNom(), administrateur.getPrenom(), administrateur.getAdresseMail());
    }

    @DeleteMapping("/{id}")
    public String deleteAdministrateur(@PathVariable("id") Long id) {
        serviceAdministrateur.supprimerAdministrateur(id);
        return "L'administrateur d'ID " + id + " a été supprimé avec succès.";
    }

    @GetMapping
    public List<Administrateur> getAllAdministrateurs() {
        return serviceAdministrateur.obtenirTousLesAdministrateurs();
    }
}
