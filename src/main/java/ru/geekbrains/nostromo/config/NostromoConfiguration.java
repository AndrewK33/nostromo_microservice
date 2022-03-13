package ru.geekbrains.nostromo.config;


import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.nostromo.entity.Rover;
import ru.geekbrains.nostromo.entity.repository.RoverRepository;

@SuppressWarnings("ALL")
@Configuration
@Slf4j
public class NostromoConfiguration {


    @Bean
    public CommandLineRunner getLoadService(RoverRepository roverRepository) {
        return args -> {
            log.info("Data loading is starting");
            log.info("Data={}", roverRepository.save(new Rover("testRover_1", "888")));
            log.info("Data={}", roverRepository.save(new Rover("testRover_2", "888")));
            log.info("Data={}", roverRepository.save(new Rover("testRover_3", "889")));
            log.info("Data was loaded");
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
