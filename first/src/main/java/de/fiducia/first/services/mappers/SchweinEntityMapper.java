package de.fiducia.first.services.mappers;

import java.util.Iterator;
import java.util.List;

import org.mapstruct.Mapper;

import de.fiducia.first.repositories.entities.SchweinEntity;
import de.fiducia.first.services.model.Schwein;

@Mapper(componentModel =  "spring")
public interface SchweinEntityMapper {

	Schwein convert(SchweinEntity entity);
	SchweinEntity convert(Schwein schwein);
	
	List<Schwein> convert(List<SchweinEntity> schweineEntities);
	
}
