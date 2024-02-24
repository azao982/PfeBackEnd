package com.example.demo.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Services.ApiService;
import com.example.demo.entities.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // Ajout d'un préfixe pour toutes les URL de l'API
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/ajouterApi")
    public ResponseEntity<String> ajouterApi(@RequestBody API api) {
        try {
            apiService.ajouterApi(api);
            return ResponseEntity.ok("Api ajoutée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout d'api");
        }
    }

    @GetMapping("/consulterApis") // Modification du nom de l'endpoint
    public List<API> getApis() {
        return apiService.getAllApis();
    }

    @DeleteMapping("/supprimerApi/{idApi}")
    public ResponseEntity<Map<String, String>> supprimerApi(@PathVariable Long idApi) {
        Map<String, String> response = new HashMap<>();
        try {
            apiService.supprimerApi(idApi);
            response.put("message", "Api deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Failed to delete Api");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idApi}")
    public ResponseEntity<API> getById(@PathVariable Long idApi) {
        API entity = apiService.getById(idApi);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifierApi/{idApi}") // Modification du nom de l'endpoint
    public ResponseEntity<String> updateApi(@RequestBody API api, @PathVariable Long idApi) {
        try {
            apiService.updateApi(api, idApi);
            return ResponseEntity.ok("Api modifiée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la modification de l'api");
        }
    }
}
