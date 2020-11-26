package de.fiducia.first.services.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
	
	@Bean
	@Qualifier("antipathen")
	public List<String> antipathen() {
		return List.of("Peter","Paul","Mary", "Attila");
	}

	@Bean
	@Qualifier("fruits")
	public List<String> fruits() {
		return List.of("Apple","Banana","Strawberry", "Raspberry");
	}

}
