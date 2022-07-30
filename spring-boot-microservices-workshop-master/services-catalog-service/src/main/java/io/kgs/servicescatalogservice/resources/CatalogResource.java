package io.javabrains.servicescatalogservice.resources;

import io.javabrains.servicescatalogservice.models.CatalogItem;
import io.javabrains.servicescatalogservice.models.services;
import io.javabrains.servicescatalogservice.models.Rating;
import io.javabrains.servicescatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    services services = restTemplate.getForObject("http://services-info-service/servicess/" + rating.getservicesId(), services.class);
                    return new CatalogItem(services.getName(), services.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());

    }
}

/*
Alternative WebClient way
services services = webClientBuilder.build().get().uri("http://localhost:8082/servicess/"+ rating.getservicesId())
.retrieve().bodyToMono(service.class).block();
*/