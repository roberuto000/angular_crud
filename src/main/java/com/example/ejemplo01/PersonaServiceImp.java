package com.example.ejemplo01;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImp implements PersonaService{
	
	
	private static final Logger log = LoggerFactory.getLogger(PersonaServiceImp.class);


	@Autowired
	private PersonaRepository repository;
	
	@Override
	public List<Persona> listar() {
		return repository.findAll();
	}

	@Override
	public Persona listarId(int id) {
		log.info("metodo listarId: {}", id);
		return repository.findById(id);
	}

	@Override
	public Persona add(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public Persona edit(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public Persona delete(int id) {
		Persona p = repository.findById(id);
		if(p != null) {
			repository.delete(p);
		}
		return p;
	}
	
	

}
