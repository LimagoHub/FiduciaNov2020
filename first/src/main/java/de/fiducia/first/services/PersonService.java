package de.fiducia.first.services;

import de.fiducia.first.controllers.dtos.PersonDTO;

public interface PersonService {

	boolean speichern(PersonDTO person) throws PersonServiceException;

}