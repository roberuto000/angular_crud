package com.example.ejemplo01;

import java.util.List;

public interface PersonaService {

	List<Persona> listar();

	Persona listarId(int id);

	Persona add(Persona persona);

	Persona edit(Persona p);

	Persona delete(int id);

}
