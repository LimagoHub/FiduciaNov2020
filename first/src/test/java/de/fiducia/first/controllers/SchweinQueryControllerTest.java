package de.fiducia.first.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.fiducia.first.controllers.dtos.SchweinDTO;
import de.fiducia.first.controllers.mapper.SchweinDTOMapper;
import de.fiducia.first.services.SchweinService;

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

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test1() {
		String result = restTemplate.getForObject("/schweine/schwein/012345678901234567890123456789111111", String.class);
		System.out.println(result);
	}

}
