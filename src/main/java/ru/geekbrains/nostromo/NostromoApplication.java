package ru.geekbrains.nostromo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import ru.geekbrains.nostromo.config.NostromoConfiguration;

@EnableDiscoveryClient
@SpringBootApplication
@Import(NostromoConfiguration.class)
public class NostromoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NostromoApplication.class, args);
	}

}
