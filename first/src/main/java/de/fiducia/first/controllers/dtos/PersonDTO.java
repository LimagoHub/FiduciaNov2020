package de.fiducia.first.controllers.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class PersonDTO {
	
	@NotEmpty
	@Size(min = 36, max = 36)
	private String id;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String vorname;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String nachname;

}
