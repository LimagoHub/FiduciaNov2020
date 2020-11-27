package de.fiducia.first.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.fiducia.first.repositories.SchweinRepository;
import de.fiducia.first.services.mappers.SchweinEntityMapper;
import de.fiducia.first.services.model.Schwein;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
public class SchweineServiceImplTest {
	@Mock
	private List<String> antipathenMock;

	@Mock
	private SchweinEntityMapper mapperMock;

	@Mock
	private SchweinRepository repositoryMock;
	@InjectMocks
	private SchweineServiceImpl objectUnderTest;

	
	@Test
	public void speichern_ParameterNull_throwsSchweineServiceException() {
		SchweineServiceException ex = assertThrows(SchweineServiceException.class , ()->objectUnderTest.speichern(null));
		assertEquals("Parameter darf nicht null sein", ex.getMessage());
	}
	
	@Test
	public void speichern_WrongName_throwsSchweineServiceException() {
		Schwein schwein = Schwein.builder().id("012345678901234567890123456789012345").name("John").gewicht(10).build();
		
		when(antipathenMock.contains(anyString())).thenReturn(true);
		
		SchweineServiceException ex = assertThrows(SchweineServiceException.class , ()->objectUnderTest.speichern(schwein));
		assertEquals("Antipath", ex.getMessage());
	}
	
}
