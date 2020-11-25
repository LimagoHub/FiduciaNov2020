package de.fiducia.first.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("lower")
public class TranslationServiceSecondImpl implements TranslationService {

	@Override
	public String translate(String message) {
		// TODO Auto-generated method stub
		return message.toLowerCase();
	}

}
