package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Structure;

public interface StructureRepo extends JpaRepository<Structure,Long>{

}
