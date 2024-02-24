package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ApiRepo;
import com.example.demo.entities.API;

@Service
public class ApiService {
	@Autowired
	private ApiRepo apiRepo;
	
	 public ApiService(ApiRepo apiRepo) {
	        this.apiRepo = apiRepo;
	    }
	 public API ajouterApi(API api) {
	        return apiRepo.save(api);
	    }
	 public API getById(Long id) {

	        return apiRepo.findById(id).orElse(null);
	    }

	    public List<API> getAllApis() {
	        return apiRepo.findAll();
	    }
	    public void supprimerApi(Long idApi) {
	        apiRepo.deleteById(idApi);
	    }

	    public boolean updateApi(API api, long idApi) {
	        Optional<API> apiOptional = apiRepo.findById((long) idApi);
	        
	        if (apiOptional.isPresent()) {
	            API apiToUpdate = apiOptional.get();
	            apiToUpdate.setIdApi(api.getIdApi());
	            apiToUpdate.setNom(api.getNom());
	            apiToUpdate.setCode(api.getCode());
	            apiToUpdate.setDescription(api.getDescription());
	            apiToUpdate.setInput(api.getInput());
	            apiToUpdate.setOutput(api.getOutput());
	            apiToUpdate.setCadreUtilisation(api.getCadreUtilisation());
	            apiToUpdate.setUrl(api.getUrl());
	            apiToUpdate.setMode(api.getMode());
	            apiRepo.save(apiToUpdate);
	            return true;
	        } else 
	        	return false ;  
	    }
}
