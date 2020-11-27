package de.fiducia.first.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.fiducia.first.controllers.dtos.SchweinDTO;
import de.fiducia.first.services.SchweinService;
import de.fiducia.first.services.model.Schwein;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql({"create.sql","insert.sql"})
@ExtendWith(SpringExtension.class)
public class SchweinQueryControllerTest {
//	@Mock
//	private SchweinDTOMapper mapperMock;
//
//	@Mock
//	private SchweinService serviceMock;

	@MockBean
	private SchweinService serviceMock;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test1() throws Exception{
		Schwein schwein = Schwein.builder().id("012345678901234567890123456789111112").name("Piggy").gewicht(10).build();
		Optional<Schwein> o = Optional.of(schwein);
		when(serviceMock.findeMitId(anyString())).thenReturn(o);
		
		SchweinDTO result = restTemplate.getForObject("/schweine/schwein/012345678901234567890123456789111111", SchweinDTO.class);
		assertEquals("012345678901234567890123456789111112", result.getId());
		assertEquals("Piggy", result.getName());
		assertEquals(10, result.getGewicht());
	}

	@Test
	public void test2() throws Exception{
		Schwein schwein = Schwein.builder().id("012345678901234567890123456789111112").name("Piggy").gewicht(10).build();
		Optional<Schwein> o = Optional.of(schwein);
		when(serviceMock.findeMitId(anyString())).thenReturn(o);
		
		ResponseEntity<SchweinDTO> entity = restTemplate.exchange("/schweine/schwein/012345678901234567890123456789111111", HttpMethod.GET, null, SchweinDTO.class);
		
		SchweinDTO result = entity.getBody();
		assertEquals("012345678901234567890123456789111112", result.getId());
		assertEquals("Piggy", result.getName());
		assertEquals(10, result.getGewicht());
	}

	
	@Test
	public void test3() throws Exception{
		
		Optional<Schwein> o = Optional.empty();
		when(serviceMock.findeMitId(anyString())).thenReturn(o);
		
		ResponseEntity<SchweinDTO> entity = restTemplate.exchange("/schweine/schwein/012345678901234567890123456789111111", HttpMethod.GET, null, SchweinDTO.class);
		
		assertEquals(HttpStatus.NOT_FOUND,entity.getStatusCode());
	}
	@Test
	public void test4() throws Exception{
		
		List<Schwein> schweine = List.of(
				Schwein.builder().id("012345678901234567890123456789111112").name("Piggy").gewicht(10).build(),
				Schwein.builder().id("012345678901234567890123456789111113").name("Babe").gewicht(10).build()
		);
		when(serviceMock.findeAlle()).thenReturn(schweine);
		
		ResponseEntity<List<SchweinDTO>> entity = restTemplate.exchange("/schweine", HttpMethod.GET, null,  new ParameterizedTypeReference<List<SchweinDTO>>() {   });
		
		List<SchweinDTO> schweineListe = entity.getBody();
		assertEquals(2, schweineListe.size());
	}
}
