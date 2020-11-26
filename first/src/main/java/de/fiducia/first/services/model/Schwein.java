package de.fiducia.first.services.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;


@Data
@Builder
@AllArgsConstructor()
public class Schwein {
	
	@Setter(value = AccessLevel.PRIVATE)
	private String id;
	
	private String name;
	
	@Setter(value = AccessLevel.PRIVATE)
	private int gewicht;
	
	public void fressen() {
		gewicht ++;
	}

}
