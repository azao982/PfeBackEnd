package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.DemandeApiRepo;
import com.example.demo.entities.DemandeApi;
@Service
public class DemApiService {
	@Autowired
	private DemandeApiRepo demandeApiRepo;
	
	 public DemApiService(DemandeApiRepo demandeApiRepo) {
	        this.demandeApiRepo = demandeApiRepo;
	    }
	 public DemandeApi ajouterDemApi(DemandeApi demandeapi) {
	        return demandeApiRepo.save(demandeapi);
	    }
	 public DemandeApi getById(Long idDemande) {

	        return demandeApiRepo.findById(idDemande).orElse(null);
	    }

	    public List<DemandeApi> getAllApis() {
	        return demandeApiRepo.findAll();
	    }
	    public void supprimerDemApi(Long idDemande) {
	    	demandeApiRepo.deleteById(idDemande);
	    }

	    public boolean updateApi(DemandeApi demandeApi, long idDemande) {
	        Optional<DemandeApi> apiOptional = demandeApiRepo.findById((long) idDemande);
	        
	        if (apiOptional.isPresent()) {
	            DemandeApi apiToUpdate = apiOptional.get();
	            apiToUpdate.setIdDemande(demandeApi.getIdDemande());
	            apiToUpdate.setDescription(demandeApi.getDescription());
	            apiToUpdate.setReference(demandeApi.getReference());
	            demandeApiRepo.save(apiToUpdate);
	            return true;
	        } else 
	        	return false ;  
	    }
}
