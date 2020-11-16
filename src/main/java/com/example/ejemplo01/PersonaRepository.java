package com.example.ejemplo01;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PersonaRepository extends Repository<Persona, Integer> {

	List<Persona> findAll();

	Persona findById(Integer id);

	Persona save(Persona persona);

	void delete(Persona p);

}
