package de.fiducia.first.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fiducia.first.controllers.dtos.SchweinDTO;
import de.fiducia.first.controllers.mapper.SchweinDTOMapper;
import de.fiducia.first.services.SchweinService;

@RestController
@RequestMapping("/schweine")
public class SchweinQueryController {

	private final SchweinService service;
	private final SchweinDTOMapper mapper;

	public SchweinQueryController(SchweinService service, final SchweinDTOMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	
	@GetMapping(path = "/schwein/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SchweinDTO> findSchweinBy(@PathVariable String id) throws Exception{
		return ResponseEntity.of(service.findeMitId(id).map(mapper::convert));
	}
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SchweinDTO>> findeAlle() throws Exception{
		return ResponseEntity.ok(mapper.convert(service.findeAlle()));
	}
	
}
