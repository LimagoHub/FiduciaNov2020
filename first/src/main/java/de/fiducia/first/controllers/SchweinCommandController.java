package de.fiducia.first.controllers;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fiducia.first.controllers.dtos.SchweinDTO;
import de.fiducia.first.controllers.mapper.SchweinDTOMapper;
import de.fiducia.first.services.SchweinService;

@RestController
@RequestMapping("/schweine")
public class SchweinCommandController {

	private final SchweinService service;
	private final SchweinDTOMapper mapper;
	
	
	public SchweinCommandController(SchweinService service, SchweinDTOMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> save(@Valid @RequestBody SchweinDTO schweinDTO) throws Exception{
		service.speichern(mapper.convert(schweinDTO));
		return ResponseEntity.ok().build();
	}
}
