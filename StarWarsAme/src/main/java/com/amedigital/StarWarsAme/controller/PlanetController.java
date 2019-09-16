package com.amedigital.StarWarsAme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amedigital.StarWarsAme.model.Planet;
import com.amedigital.StarWarsAme.model.StarWarsAPIPlanet;
import com.amedigital.StarWarsAme.services.PlanetService;
import com.amedigital.StarWarsAme.services.StarWarsAPIPlanetService;

@RestController
@RequestMapping("/api")
public class PlanetController {
	
	@Autowired
	PlanetService ps;
	
	@Autowired
	StarWarsAPIPlanetService sws;
	
	
	@GetMapping("/planets")
	public List<Planet> planets(){
		return ps.findAll();
	}
	
	@GetMapping("/planetapi")
	public List<StarWarsAPIPlanet> listAPIPlanet(){
		return sws.listAllPlanet();
	}
	
	@GetMapping("/planet")
	public ResponseEntity<Planet> planetByName(@RequestParam("name") String name){
		if(ps.findByName(name).isPresent())
			return ResponseEntity.accepted().body(ps.findByName(name).get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/planet/{id}")
	public ResponseEntity<Planet> planetById(@PathVariable Long id) {
		if(ps.findById(id).isPresent())
			return ResponseEntity.accepted().body(ps.findById(id).get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/planet")
	public ResponseEntity<Planet> savePlanet(@RequestBody Planet planet) {
		if(ps.existsPlanet(planet.getName()))
			return ResponseEntity.badRequest().build();
		else {
			Integer numberFilms = ps.numberFilms(planet.getName());
			planet.setTotalFilms(numberFilms);
			return ResponseEntity.status(HttpStatus.CREATED).body(ps.save(planet));
		}
	}
	
	@DeleteMapping("/planet")
	public ResponseEntity<?> deletePlanet(@RequestBody Planet planet) {
		try {
			ps.delete(ps.findByName(planet.getName()).get().getId());
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}	
}
