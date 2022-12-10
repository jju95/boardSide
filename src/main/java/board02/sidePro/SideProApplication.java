package board02.sidePro;

import board02.sidePro.common.PropertiesManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class SideProApplication {

	public static void main(String[] args) {
		SpringApplication.run(SideProApplication.class, args);
	}

}
