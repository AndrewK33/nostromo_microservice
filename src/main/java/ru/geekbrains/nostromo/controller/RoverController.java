package ru.geekbrains.nostromo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.nostromo.dto.Planet;
import ru.geekbrains.nostromo.entity.Rover;
import ru.geekbrains.nostromo.service.RoverClient;
import ru.geekbrains.nostromo.service.RoverDiscoveryPlanet;
import ru.geekbrains.nostromo.service.RoverService;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class RoverController {

    private final RoverService roverService;
    private final RoverClient roverClient;
    private final RoverDiscoveryPlanet roverDiscoveryPlanet;


    @Autowired
    public RoverController(RoverService roverService, RoverClient roverClient, RoverDiscoveryPlanet roverDiscoveryPlanet) {
        this.roverService = roverService;
        this.roverClient = roverClient;
        this.roverDiscoveryPlanet = roverDiscoveryPlanet;
    }


    @RequestMapping(
            value = "/rover/available",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public List<String> getAvailableRovers(){
        return roverClient.getRoverUrls();
    }

    @RequestMapping(
            value = "/discover/planet",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public List<Planet> discoveryPlanet() {
        return roverDiscoveryPlanet.getDiscoveryListPlanet();
    }


    @RequestMapping(
            value = "/rover/all",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public List<Rover> getAllRovers() {
        return roverService.getAllRovers();
    }
}
