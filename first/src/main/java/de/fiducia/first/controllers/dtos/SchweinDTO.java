package de.fiducia.first.controllers.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class SchweinDTO {
	@NotEmpty
	@Size(min = 36, max = 36)
	private String id;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String name;
	
	@DecimalMin(inclusive = true, value = "10")
	private int gewicht;
}
