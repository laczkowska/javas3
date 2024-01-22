package com.example.updaters.clients;

import com.example.updaters.clients.contract.RandomPersonDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RandomDataClient implements IRandomDataClient {

    @Value("${random.data.url}")
    private String randomDataUrl;

    private final RestTemplate restTemplate;

    public RandomDataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<RandomPersonDto> getRandomPeople(int dataSize) {
        String url = randomDataUrl + "?size=" + dataSize;
        RandomPersonDto[] randomPeople = restTemplate.getForObject(url, RandomPersonDto[].class);
        return List.of(randomPeople);
    }
}
