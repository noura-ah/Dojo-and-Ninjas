package com.example.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dojo.models.Dojo;
import com.example.dojo.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
    
	public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
	public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
	
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return (optionalDojo.isPresent())? optionalDojo.get(): null;
    }

	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
    

}