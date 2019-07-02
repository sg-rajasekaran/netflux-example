package guru.springframework.bootstrap;

import guru.springframework.netfluxexample.domain.Movie;
import guru.springframework.netfluxexample.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

/*
 * created by NR on 2 Jul 2019
 */
@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public void run(String...args) throws Exception {

        //Clear all old data
        movieRepository.deleteAll().block();

        Flux.just("Silence of Lambdas", "AEon Flux","Enter the Mono<void>","The Fluxxinator",
                "Back to Future","Lord of Fluxes")
                .map(title -> new Movie(UUID.randomUUID().toString(),title))
                .flatMap(movieRepository::save)
                .subscribe(null,null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }


}
