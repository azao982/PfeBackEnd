package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Services.UserService;
import com.example.demo.entities.User;

@RestController
@RequestMapping("/users") // Mettre à jour le préfixe pour toutes les URL de l'API
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/ajouterUser")
    public ResponseEntity<String> ajouterUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("User ajouté avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de l'utilisateur");
        }
    }

    @GetMapping("/consulterUsers") // Modification du nom de l'endpoint
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/supprimerUser/{idUser}")
    public ResponseEntity<Map<String, String>> supprimerUser(@PathVariable Long idUser) {
        Map<String, String> response = new HashMap<>();
        try {
            userService.deleteUser(idUser);
            response.put("message", "Utilisateur supprimé avec succès");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Échec de la suppression de l'utilisateur");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getById(@PathVariable Long idUser) {
        User entity = userService.getUserById(idUser);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifierUser/{idUser}") // Modification du nom de l'endpoint
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long idUser) {
        try {
            userService.updateUser(user, idUser);
            return ResponseEntity.ok("Utilisateur modifié avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la modification de l'utilisateur");
        }
    }
}
