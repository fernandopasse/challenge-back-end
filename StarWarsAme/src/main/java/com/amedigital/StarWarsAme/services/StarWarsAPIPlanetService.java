package com.amedigital.StarWarsAme.services;

import java.util.List;

import com.amedigital.StarWarsAme.model.StarWarsAPI;
import com.amedigital.StarWarsAme.model.StarWarsAPIPlanet;

public interface StarWarsAPIPlanetService {

	StarWarsAPI getPlanetFromAPI(String name);
	
	List<StarWarsAPIPlanet> listAllPlanet();
	
}
