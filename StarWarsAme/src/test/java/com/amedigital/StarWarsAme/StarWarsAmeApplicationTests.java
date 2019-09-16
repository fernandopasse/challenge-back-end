package com.amedigital.StarWarsAme;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarWarsAmeApplicationTests {

	@Test
	public void contextLoads() {
	}

	
	final String URI = "http://localhost:8080/api/planet/";

	@Test
	public void testPlanetById() throws URISyntaxException
	{
		String id = "3";
		
	    RestTemplate restTemplate = new RestTemplate();
	     
        final String baseUrl = "http://localhost:" + 8080 + "/planet" + id;
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);
	     
	    assertEquals(200, result.getStatusCodeValue());
	}
	
}
