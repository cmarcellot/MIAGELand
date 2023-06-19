package com.miage.miageland.exposition;

import com.miage.miageland.entities.Billet;
import com.miage.miageland.metier.ServiceBillet;
import com.miage.miageland.utilities.BilletInexistantException;
import com.miage.miageland.utilities.BilletNonAnnulableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la ressource billets
 */
@RestController
@RequestMapping("/api/billets")
public class RestBillet {

    private final ServiceBillet serviceBillet;

    /**
     * Constructeur pour l'injection (remplace les @Autowired)
     * @param serviceBillet le bean métier billet injecté
     */
    public RestBillet(ServiceBillet serviceBillet) {
        this.serviceBillet = serviceBillet;
    }

    /**
     * Permet de récupérer les détails d'un billet
     * GET sur http://localhost:8080/api/billets/1
     * @param idBillet id du billet
     * @return le billet qui sera traduit en JSON
     */
    @GetMapping("{id}")
    public Billet getBillet(@PathVariable("id") Long idBillet) {
        return serviceBillet.recupererBillet(idBillet).orElse(null);
    }

    /**
     * Permet de créer un nouveau billet
     * POST sur http://localhost:8080/api/billets
     *
     * @param billet les détails du billet envoyés par le front
     * @return le nouveau billet en JSON
     */
    @PostMapping
    public ResponseEntity<Billet> creerBillet(@RequestBody Billet billet, @RequestParam("idVisiteur") Long idVisiteur) {
        Billet nouveauBillet = serviceBillet.creerBillet(billet.getDate(), billet.getPrix(), idVisiteur);
        return ResponseEntity.ok().body(nouveauBillet);
    }

    /**
     * Permet de supprimer un billet
     * DELETE sur http://localhost:8080/api/billets/1
     * @param idBillet id du billet à supprimer
     */
    @DeleteMapping("{id}")
    public String supprimerBillet(@PathVariable("id") Long idBillet) {
        serviceBillet.recupererBillet(idBillet).ifPresent(serviceBillet::supprimerBillet);
        return "Le billet d'ID " + idBillet + " a été supprimé avec succès.";
    }

    /**
     * Permet de récupérer la liste de tous les billets
     * GET sur http://localhost:8080/api/billets
     * @return la liste des billets en JSON
     */
    @GetMapping
    public List<Billet> listerBillets() {
        return serviceBillet.obtenirTousLesBillets();
    }

    /**
     * Modifie l'état d'un billet
     * PUT sur http://localhost:8080/api/billets/1/etat
     *
     * @param idBillet id du billet
     * @param etat     nouvel état du billet
     * @return le billet modifié en JSON
     */
    @PutMapping("{id}/etat")
    public ResponseEntity<String> setEtatBillet(@PathVariable("id") Long idBillet, @RequestParam("etat") String etat) {
        try {
            // Appel à la méthode pour modifier l'état du billet
            serviceBillet.modifierEtatBillet(idBillet, etat);

            // Retourner une réponse avec le code HTTP 200 OK et un message de confirmation
            return ResponseEntity.ok().body("L'état du billet d'ID " + idBillet + " a été modifié avec succès (" + etat + ").");
        } catch (BilletInexistantException | BilletNonAnnulableException exception) {
            // En cas d'exception, retourner une réponse avec le code HTTP 400 Bad Request
            // et le message d'erreur de l'exception
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    /**
     * Vérifie la validité d'un billet
     * GET sur http://localhost:8080/api/billets/1/validation
     * @param idBillet id du billet à vérifier
     * @return une réponse HTTP avec le résultat de la vérification
     */
    @GetMapping("{id}/validation")
    public ResponseEntity<String> verifierValiditeBillet(@PathVariable("id") Long idBillet) {
        boolean estValide = serviceBillet.verifierValiditeBillet(idBillet);
        if (estValide) {
            return new ResponseEntity<>("Le billet est valide.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Le billet n'est pas valide.", HttpStatus.BAD_REQUEST);
        }
    }
}
