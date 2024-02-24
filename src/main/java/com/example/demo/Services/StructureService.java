package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.StructureRepo;
import com.example.demo.entities.Structure;

@Service
public class StructureService {

    @Autowired
    private StructureRepo structureRepo;

    public StructureService(StructureRepo structureRepo) {
        this.structureRepo = structureRepo;
    }

    public Structure addStructure(Structure structure) {
        return structureRepo.save(structure);
    }

    public Structure getStructureById(Long structureId) {
        return structureRepo.findById(structureId).orElse(null);
    }

    public List<Structure> getAllStructures() {
        return structureRepo.findAll();
    }

    public void deleteStructure(Long structureId) {
        structureRepo.deleteById(structureId);
    }

    public boolean updateStructure(Structure structure, long structureId) {
        Optional<Structure> structureOptional = structureRepo.findById(structureId);

        if (structureOptional.isPresent()) {
            Structure structureToUpdate = structureOptional.get();
            structureToUpdate.setIdStructure(structure.getIdStructure());
            structureToUpdate.setNom(structure.getNom());
            structureToUpdate.setCode(structure.getCode());
            structureToUpdate.setEmail(structure.getEmail());
            structureToUpdate.setPrenom(structure.getPrenom());
            structureToUpdate.setNumtel(structure.getNumtel());
            structureRepo.save(structureToUpdate);
            return true;
        } else {
            return false;
        }
    }
}
