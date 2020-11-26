package de.fiducia.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.fiducia.first.controllers.dtos.PersonDTO;
import de.fiducia.first.repositories.PersonRepository;
import de.fiducia.first.repositories.entities.Person;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = PersonServiceException.class)
@Slf4j
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	private final PersonDTOMapper mapper;
	private final List<String> antipathen;

	public PersonServiceImpl(final PersonRepository personRepository, final PersonDTOMapper mapper,@Qualifier("antipathen") final List<String> antipathen) {
		this.personRepository = personRepository;
		this.mapper = mapper;
		this.antipathen = antipathen;
		System.out.println(antipathen);
	}
	
	
	@Override
	public boolean speichern(PersonDTO person) throws PersonServiceException {
		try {
			if(antipathen.contains(person.getVorname()))
				throw new PersonServiceException("Antipath");
			
			boolean retval = personRepository.existsById(person.getId());
			Person entity = mapper.convert(person);
			personRepository.save(entity);
			
			entity.setVorname("Erika");
			
			return retval;
		} catch (RuntimeException e) {
			log.error("Upps",e);
			throw new PersonServiceException(e);
		}
	}
	
}
