package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Services.StructureService;
import com.example.demo.entities.Structure;

@RestController
@RequestMapping("/structures") // Mettre à jour le préfixe pour toutes les URL de l'API
@CrossOrigin(origins = "*", maxAge = 3600)
public class StructureController {

    private final StructureService structureService;

    public StructureController(StructureService structureService) {
        this.structureService = structureService;
    }

    @PostMapping("/ajouterStructure")
    public ResponseEntity<String> ajouterStructure(@RequestBody Structure structure) {
        try {
            structureService.addStructure(structure);
            return ResponseEntity.ok("Structure ajoutée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de la structure");
        }
    }

    @GetMapping("/consulterStructures") // Modification du nom de l'endpoint
    public List<Structure> getStructures() {
        return structureService.getAllStructures();
    }

    @DeleteMapping("/supprimerStructure/{idStructure}")
    public ResponseEntity<Map<String, String>> supprimerStructure(@PathVariable Long idStructure) {
        Map<String, String> response = new HashMap<>();
        try {
            structureService.deleteStructure(idStructure);
            response.put("message", "Structure supprimée avec succès");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Échec de la suppression de la structure");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idStructure}")
    public ResponseEntity<Structure> getById(@PathVariable Long idStructure) {
        Structure entity = structureService.getStructureById(idStructure);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifierStructure/{idStructure}") // Modification du nom de l'endpoint
    public ResponseEntity<String> updateStructure(@RequestBody Structure structure, @PathVariable Long idStructure) {
        try {
            structureService.updateStructure(structure, idStructure);
            return ResponseEntity.ok("Structure modifiée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la modification de la structure");
        }
    }
}
