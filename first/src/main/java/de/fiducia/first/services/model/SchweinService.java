package de.fiducia.first.services.model;

import java.util.List;
import java.util.Optional;

public interface SchweinService {

	void speichern(Schwein schwein);

	Optional<Schwein> findeMitId(String id);

	List<Schwein> findeAlle();

	// Query
	Schwein fuettern(Schwein schwein);

	// Command
	boolean fuettern(String id);

}