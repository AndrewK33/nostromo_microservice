package ru.geekbrains.nostromo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.nostromo.dto.Planet;
import ru.geekbrains.nostromo.entity.Rover;
import ru.geekbrains.nostromo.entity.repository.RoverRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class RoverDiscoveryPlanet {

    private final RoverClient roverClient;
    private RestTemplate restTemplate;

    @Autowired
    public RoverDiscoveryPlanet(RoverClient roverClient, RestTemplate restTemplate) {
        this.roverClient = roverClient;
        this.restTemplate = restTemplate;
    }

    public List<Planet> getDiscoveryListPlanet(){
        List<Planet> planetList = new ArrayList<>();
        final List<String> roverUrls = roverClient.getRoverUrls();
        for (String urlForRover: roverUrls) {
            planetList.add(restTemplate.getForObject(urlForRover + "/discover/planet", Planet.class));
        }
        return planetList;
    }


}
