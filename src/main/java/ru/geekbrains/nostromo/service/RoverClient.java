package ru.geekbrains.nostromo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoverClient {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public RoverClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public List<String> getRoverUrls(){
        return discoveryClient.getInstances("rover-service")
                .stream()
                .map(ServiceInstance::getUri)
                .map(URI::toString)
                .collect(Collectors.toList());
    }


}
