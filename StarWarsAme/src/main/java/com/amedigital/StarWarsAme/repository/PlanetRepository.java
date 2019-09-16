package com.amedigital.StarWarsAme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amedigital.StarWarsAme.model.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long>{
	Optional<Planet> findByName(String name);
	boolean existsByName(String name);	
}
