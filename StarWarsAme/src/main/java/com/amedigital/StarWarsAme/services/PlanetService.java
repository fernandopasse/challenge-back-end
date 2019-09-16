package com.amedigital.StarWarsAme.services;

import java.util.List;
import java.util.Optional;

import com.amedigital.StarWarsAme.model.Planet;


public interface PlanetService {
	
	public List<Planet> findAll();
	
	public Optional<Planet> findById(Long id);
	
	public Optional<Planet> findByName(String name);
	
	public Planet save(Planet planet);
	
	public void delete(Long id);
	
	public Integer numberFilms(String name);
	
	public boolean existsPlanet(String name);
		
}
