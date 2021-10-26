package de.gtwsp21.handmanserv.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

	@Value("${testmodus:false}")
	private boolean testmodus;

	public boolean isTestmodus() {
		return testmodus;
	}

	public void setTestmodus(boolean testmodus) {
		this.testmodus = testmodus;
	}

	
	
}
