package de.fiducia.first.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	// Constructor Injection
	private final TranslationService service;
	
	
	public Demo(@Qualifier("upper") final TranslationService service) {
		this.service = service;
		System.out.println("##################");
		System.out.println(service.translate("Ctor demo"));
		System.out.println("##################");
	}
	
	@PostConstruct
	public void setUp() {
		System.out.println(service.translate("SetUp"));
	}
	
	@PreDestroy
	public void dispose() {
		System.out.println("Kaputt");
	}

}
