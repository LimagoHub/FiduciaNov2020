package de.fiducia.first.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import de.fiducia.first.controllers.dtos.PersonDTO;

@RestController
@RequestMapping("/personen")
public class DemoController {
	
	
	@GetMapping(path="/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
	public String gruss() {
		return "Hallo Rest";
	}

	@GetMapping(path="/person/{id}", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> person(@PathVariable String id) {
		Optional<PersonDTO> optPers = Optional.of(PersonDTO.builder()
				.id(id)
				.vorname("John")
				.nachname("Doe")
				.build());
		return ResponseEntity.of(optPers);
	}

	@GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<PersonDTO> personByVorname(@RequestParam String vorname,@RequestParam String nachname) {
		List<PersonDTO> liste = new ArrayList<>();
		liste.add(PersonDTO.builder()
				.id(UUID.randomUUID().toString())
				.vorname(vorname)
				.nachname("Doe")
				.build());
		return liste;
	}
	
	@PostMapping(path = "/toUpper",produces = {MediaType.APPLICATION_JSON_VALUE}, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> echo(@RequestBody PersonDTO person) {
		person.setVorname(person.getVorname().toUpperCase());
		person.setNachname(person.getNachname().toUpperCase());
		return ResponseEntity.ok(person);
	}
	
	@DeleteMapping(path="/person", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody PersonDTO person) { 
		System.out.println(person + " wird geloescht!");
	}
	
	@DeleteMapping(path="/person/{id}", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) { 
		System.out.println("person mit id " + id + " wird geloescht!");
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path="/person", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@Valid @RequestBody PersonDTO person) { 
		System.out.println(person + " wird gespeichert!");
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping(path="/person", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveNotIdempotent(@RequestBody PersonDTO person, UriComponentsBuilder b) { 
		person.setId(UUID.randomUUID().toString());
		UriComponents uriComponents = b.path("personen/person/{id}").buildAndExpand(person.getId());
		System.out.println(person + " wird gespeichert!");
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

}
