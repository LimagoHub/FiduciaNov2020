package de.fiducia.first.controllers.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.fiducia.first.controllers.dtos.SchweinDTO;
import de.fiducia.first.services.model.Schwein;

@Mapper(componentModel = "spring")
public interface SchweinDTOMapper {

	SchweinDTO convert(Schwein schwein);
	Schwein convert(SchweinDTO dto);
	
	List<SchweinDTO> convert(List<Schwein> schweine);
}
