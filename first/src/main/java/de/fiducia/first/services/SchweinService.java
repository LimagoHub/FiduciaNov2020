package de.fiducia.first.services;

import java.util.List;
import java.util.Optional;

import de.fiducia.first.services.model.Schwein;

public interface SchweinService {

	void speichern(Schwein schwein) throws SchweineServiceException;

	Optional<Schwein> findeMitId(String id) throws SchweineServiceException;

	List<Schwein> findeAlle() throws SchweineServiceException;

	// Query
	Schwein fuettern(Schwein schwein) throws SchweineServiceException;

	// Command
	boolean fuettern(String id) throws SchweineServiceException;

}