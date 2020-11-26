package de.fiducia.first.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tblpersonen")
@NamedQuery(name = "Person.findeMitNachname",query = "SELECT p FROM Person p where p.nachname like :nachname")
public class Person {
	@Id
	@Column(length = 36)
	private String id;
	@Column(length = 30)
	private String vorname;
	@Column(length = 30, nullable = false)
	private String nachname;
}
