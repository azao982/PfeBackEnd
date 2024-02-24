package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class API {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idApi;
    private String nom;
    private String code;
    private String description;
    private String input;
    private String output;
    private String cadreUtilisation;
    private String url;
    private String mode;

    
    public API() {
    }


    public API(Long idApi, String nom, String code, String description, String input, String output, String cadreUtilisation, String url, String mode) {
        this.idApi = idApi;
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.input = input;
        this.output = output;
        this.cadreUtilisation = cadreUtilisation;
        this.url = url;
        this.mode = mode;
    }

    // Getters et Setters

    public Long getIdApi() {
        return idApi;
    }

    public void setIdApi(Long idApi) {
        this.idApi = idApi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getCadreUtilisation() {
        return cadreUtilisation;
    }

    public void setCadreUtilisation(String cadreUtilisation) {
        this.cadreUtilisation = cadreUtilisation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
