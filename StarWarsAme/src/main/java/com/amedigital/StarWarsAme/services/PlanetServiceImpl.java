package com.amedigital.StarWarsAme.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amedigital.StarWarsAme.model.Planet;
import com.amedigital.StarWarsAme.model.StarWarsAPI;
import com.amedigital.StarWarsAme.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService{

	@Autowired
	PlanetRepository pr;
	
	
	@Autowired
	StarWarsAPIPlanetService swap;
	
	@Override
	public List<Planet> findAll() {
		return pr.findAll();
	}

	@Override
	public Optional<Planet> findById(Long id) {
		return pr.findById(id);
	}

	@Override
	public Optional<Planet> findByName(String name) {
		return pr.findByName(name);
	}

	@Override
	public Planet save(Planet planet) {
		
		//Cria um novo planeta e adiciona a ele os dados passados na chamada
		Planet newPlanet = new Planet();
		newPlanet.setName(planet.getName());
		newPlanet.setClimate(planet.getClimate());
		newPlanet.setTerrain(planet.getTerrain());
		newPlanet.setTotalFilms(planet.getTotalFilms());
		
		return pr.save(newPlanet);
	}

	@Override
	public void delete(Long id) {
		pr.deleteById(id);
	}

	@Override
	public Integer numberFilms(String name) {
		
		StarWarsAPI swapi = swap.getPlanetFromAPI(name);
	    
		return swapi.getResults().get(0).getFilms().size();
	}

	@Override
	public boolean existsPlanet(String name) {
		return pr.existsByName(name);
	}

}
