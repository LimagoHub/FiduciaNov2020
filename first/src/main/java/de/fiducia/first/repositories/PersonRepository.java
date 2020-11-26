package de.fiducia.first.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.fiducia.first.repositories.entities.Person;
import de.fiducia.first.repositories.entities.TinyPerson;

public interface PersonRepository extends CrudRepository<Person, String>{

	
	List<Person> findByVorname(String vorname);
	List<Person> findeMitNachname(String nachname);
	
	@Query("SELECT p from Person p")
	List<Person> xyz();
	
	@Query("SELECT new de.fiducia.first.repositories.entities.TinyPerson(p.id,p.nachname) From Person p")
	List<TinyPerson> findeKleinePersonen();
}
