package com.amedigital.StarWarsAme.services;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amedigital.StarWarsAme.model.StarWarsAPI;
import com.amedigital.StarWarsAme.model.StarWarsAPIPlanet;

@Service
public class StarWarsAPIPlanetServiceImpl implements StarWarsAPIPlanetService {

	final String URI = "https://swapi.co/api/planets/?search=";
	
	final String URI_PAGE = "https://swapi.co/api/planets/?page=";

	@Override
	public StarWarsAPI getPlanetFromAPI(String name) {
		
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:55.0) Gecko/20100101 Firefox/55.0");
	    HttpEntity<?> entity = new HttpEntity<>(headers);

	    HttpEntity<StarWarsAPI> response = restTemplate.exchange(this.URI + name, HttpMethod.GET, entity, StarWarsAPI.class);
	    
	    StarWarsAPI swapi = response.getBody();
	    
	    return swapi;
	
	}

	@Override
	public List<StarWarsAPIPlanet> listAllPlanet() {
		int id = 1;
		
		List<StarWarsAPIPlanet> totalPlanet;
		
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:55.0) Gecko/20100101 Firefox/55.0");
	    HttpEntity<?> entity = new HttpEntity<>(headers);

	    HttpEntity<StarWarsAPI> response = restTemplate.exchange(this.URI_PAGE + id, HttpMethod.GET, entity, StarWarsAPI.class);
	    
	    StarWarsAPI swapi = response.getBody();
	   
	    totalPlanet = swapi.getResults();
	    
	    while(true) {
	    	try {
	    		totalPlanet.addAll(restTemplate.exchange(this.URI_PAGE + id, HttpMethod.GET, entity, StarWarsAPI.class).getBody().getResults());
	    	}catch (Exception e) {
				break;
			}
	    	id++;
	    }
	    
	    return totalPlanet;
	}

}
