package com.example.ejemplo01;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class PersonaController {
	
	
	private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

	
	@Autowired
	PersonaService personaService;
	
	@GetMapping
	public List<Persona> listar(){
		return personaService.listar();
	}
	
	@PostMapping
	public Persona agregar(@RequestBody Persona persona) {
		log.info("Nombre:{}, Apellido:{}", persona.getName(), persona.getApellidos());
		return personaService.add(persona);
	}
	
	@GetMapping(path = {"/{id}"})
	public Persona listarId(@PathVariable("id") int id) {
		log.info("Metodo listarId: {}", id);
		return personaService.listarId(id);
	}

	@PutMapping(path = {"/{id}"})
	public Persona editar(@RequestBody Persona persona, @PathVariable("id") int id) {
		log.info(persona.toString());
		log.info(""+id);
		persona.setId(id);
		return personaService.edit(persona);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Persona eliminar(@PathVariable("id") int id) {
		log.info("Metodo eliminar: {}", id);
		return personaService.delete(id);
	}
}
