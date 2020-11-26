package de.fiducia.first.services.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.fiducia.first.repositories.SchweinRepository;
import de.fiducia.first.repositories.entities.SchweinEntity;
import de.fiducia.first.services.mappers.SchweinEntityMapper;

@Service
@Transactional
public class SchweineServiceImpl implements SchweinService {

	private final SchweinRepository repository;
	private final SchweinEntityMapper mapper;

	public SchweineServiceImpl(SchweinRepository repository, final SchweinEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	@Override
	public void speichern(Schwein schwein) {
		repository.save(mapper.convert(schwein));
	}
	
	@Override
	public Optional<Schwein> findeMitId(String id) {
		return repository.findById(id).map(mapper::convert);
	}
	@Override
	public List<Schwein> findeAlle() {
		List<SchweinEntity> liste = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(liste::add);
		return mapper.convert(liste);
	}
	
	// Query
	@Override
	public Schwein fuettern(Schwein schwein) {
		schwein.fressen();
		return schwein;
	}
	
	// Command
	@Override
	public boolean fuettern(String id) {
		Optional<SchweinEntity> schweinEntityOptinal = repository.findById(id);
		if(! schweinEntityOptinal.isPresent()) return false;
		
		SchweinEntity entity = schweinEntityOptinal.get();
		entity.setGewicht(entity.getGewicht() + 1);
		return true;
	}
}
