package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DemandeApi {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDemande;
    
   // private Long idApi;
    private String description;
    private String reference;

  
    public DemandeApi() {
    }

   
    public DemandeApi(Long idDemande , String description, String reference) {
        this.idDemande = idDemande;
        //this.idApi = idApi;
        this.description = description;
        this.reference = reference;
    }

    // Getters et Setters

    public Long getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Long idDemande) {
        this.idDemande = idDemande;
    }

   // public Long getIdApi() {
   //     return idApi;
   // }

   // public void setIdApi(Long idApi) {
     //   this.idApi = idApi;
    //}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
