package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.DemApiService;
import com.example.demo.entities.DemandeApi;
@RestController
@RequestMapping("/Demande") // Ajout d'un préfixe pour toutes les URL de l'API
@CrossOrigin(origins = "*", maxAge = 3600)
public class DemandeController {
	 private final DemApiService demapiService;

	    public DemandeController(DemApiService demapiService) {
	        this.demapiService = demapiService;
	    }

	    @PostMapping("/ajouterDemApi")
	    public ResponseEntity<String> ajouterDemApi(@RequestBody DemandeApi demapi) {
	        try {
	            demapiService.ajouterDemApi(demapi);
	            return ResponseEntity.ok("DemandeApi ajoutée avec succès");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du demande d'api");
	        }
	    }

	    @GetMapping("/consulterDemandesApis") // Modification du nom de l'endpoint
	    public List<DemandeApi> getApis() {
	        return demapiService.getAllApis();
	    }

	    @DeleteMapping("/supprimerDemApi/{idDemande}")
	    public ResponseEntity<Map<String, String>> supprimerDemApi(@PathVariable Long idDemande) {
	        Map<String, String> response = new HashMap<>();
	        try {
	            demapiService.supprimerDemApi(idDemande);
	            response.put("message", "DemandeApi deleted successfully");
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } catch (Exception e) {
	            response.put("message", "Failed to delete DemandeApi");
	            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/{idDemande}")
	    public ResponseEntity<DemandeApi> getById(@PathVariable Long idDemande) {
	        DemandeApi entity = demapiService.getById(idDemande);
	        if (entity != null) {
	            return new ResponseEntity<>(entity, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/modifierDemApi/{idDemande}") // Modification du nom de l'endpoint
	    public ResponseEntity<String> updateApi(@RequestBody DemandeApi demapi, @PathVariable Long idDemande) {
	        try {
	            demapiService.updateApi(demapi, idDemande);
	            return ResponseEntity.ok("Demande Api modifiée avec succès");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la modification du demande de l'api");
	        }
	    }
	}

