package de.fiducia.first.services;

import java.util.List;

import org.mapstruct.Mapper;

import de.fiducia.first.controllers.dtos.PersonDTO;
import de.fiducia.first.repositories.entities.Person;


@Mapper(componentModel = "spring")
public interface PersonDTOMapper {
	
	Person convert(PersonDTO dto);
	PersonDTO convert (Person person);
	
	List<PersonDTO> convert(List<Person> personen);

}
