package de.fiducia.first.controllers;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fiducia.first.controllers.dtos.PersonDTO;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	
	@GetMapping(path="/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
	public String gruss() {
		return "Hallo Rest";
	}

	@GetMapping(path="/person", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public PersonDTO person() {
		return PersonDTO.builder()
				.id(UUID.randomUUID().toString())
				.vorname("John")
				.nachname("Doe")
				.build();
	}

}
