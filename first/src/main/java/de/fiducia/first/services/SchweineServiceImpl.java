package de.fiducia.first.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.fiducia.first.repositories.SchweinRepository;
import de.fiducia.first.repositories.entities.SchweinEntity;
import de.fiducia.first.services.mappers.SchweinEntityMapper;
import de.fiducia.first.services.model.Schwein;

@Service
@Transactional(rollbackFor = SchweineServiceException.class)
public class SchweineServiceImpl implements SchweinService {

	private final SchweinRepository repository;
	private final SchweinEntityMapper mapper;
	private final List<String> antipathen;

	public SchweineServiceImpl(SchweinRepository repository, final SchweinEntityMapper mapper, final List<String> antipathen) {
		this.repository = repository;
		this.mapper = mapper;
		this.antipathen = antipathen;
	}
	
	
	@Override
	public void speichern(Schwein schwein)  throws SchweineServiceException{
		try {
			if(schwein == null) throw new SchweineServiceException("Parameter darf nicht null sein");
			if(antipathen.contains(schwein.getName())) throw new SchweineServiceException("Antipath");
			repository.save(mapper.convert(schwein));
		} catch (RuntimeException e) {
			throw new SchweineServiceException("Server Error");
		}
	}
	
	@Override
	public Optional<Schwein> findeMitId(String id) throws SchweineServiceException{
		return repository.findById(id).map(mapper::convert);
	}
	@Override
	public List<Schwein> findeAlle() throws SchweineServiceException{
		List<SchweinEntity> liste = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(liste::add);
		return mapper.convert(liste);
	}
	
	// Query
	@Override
	public Schwein fuettern(Schwein schwein) throws SchweineServiceException{
		schwein.fressen();
		return schwein;
	}
	
	// Command
	@Override
	public boolean fuettern(String id) throws SchweineServiceException{
		Optional<SchweinEntity> schweinEntityOptinal = repository.findById(id);
		if(! schweinEntityOptinal.isPresent()) return false;
		
		SchweinEntity entity = schweinEntityOptinal.get();
		entity.setGewicht(entity.getGewicht() + 1);
		return true;
	}
}
