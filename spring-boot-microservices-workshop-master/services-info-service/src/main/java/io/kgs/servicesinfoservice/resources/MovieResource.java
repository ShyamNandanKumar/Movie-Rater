package io.kgs.servicesinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public <ServiceSummary> Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        io.javabrains.servicesinfoservice.models.ServiceSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, ServiceSummary.class);
        io.javabrains.servicesinfoservice.models.Service movie = new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        return movie;

    }

}
