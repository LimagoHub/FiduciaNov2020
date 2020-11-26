package de.fiducia.first.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class TinyPerson {
	
	private final String id;
	
	private final String nachname;
}
