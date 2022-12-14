
package com.example.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.dojo.models.Ninja;
import com.example.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
    
	public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
	public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
	
	public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        return (optionalNinja.isPresent())? optionalNinja.get(): null;
    }

	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
    

}