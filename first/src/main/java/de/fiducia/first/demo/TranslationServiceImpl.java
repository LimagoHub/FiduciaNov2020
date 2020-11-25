package de.fiducia.first.demo;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("upper")
public class TranslationServiceImpl implements TranslationService {

	@Override
	public String translate(String message) {
		// TODO Auto-generated method stub
		return message.toUpperCase();
	}

}
