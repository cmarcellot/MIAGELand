package com.miage.miageland.exposition;

import com.miage.miageland.entities.Employe;
import com.miage.miageland.metier.ServiceEmploye;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class RestEmploye {

    private final ServiceEmploye serviceEmploye;

    public RestEmploye(ServiceEmploye serviceEmploye) {
        this.serviceEmploye = serviceEmploye;
    }

    @GetMapping("/{id}")
    public Employe getEmploye(@PathVariable("id") Long id) {
        return serviceEmploye.recupererEmploye(id).orElse(null);
    }

    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe) {
        return serviceEmploye.creerEmploye(employe.getNom(), employe.getPrenom(), employe.getAdresseMail());
    }

    @DeleteMapping("/{id}")
    public String deleteEmploye(@PathVariable("id") Long id) {
        serviceEmploye.supprimerEmploye(id);
        return "L'employé d'ID " + id + " a été supprimé avec succès.";
    }

    @GetMapping
    public List<Employe> getAllEmployes() {
        return serviceEmploye.obtenirTousLesEmployes();
    }
}

