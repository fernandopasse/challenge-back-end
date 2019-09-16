package com.amedigital.StarWarsAme.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StarWarsAPI {

    public Integer count;
    
    public List<StarWarsAPIPlanet> results;

	public List<StarWarsAPIPlanet> getResults() {
		return results;
	}

	public Integer getCount() {
		return count;
	}
	
	
}
