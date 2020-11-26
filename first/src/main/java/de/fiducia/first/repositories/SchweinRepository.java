package de.fiducia.first.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.fiducia.first.repositories.entities.SchweinEntity;

public interface SchweinRepository extends CrudRepository<SchweinEntity, String> {
	
	List<SchweinEntity> findByName(String name);
	List<SchweinEntity> findByGewicht(int gewicht);

}
