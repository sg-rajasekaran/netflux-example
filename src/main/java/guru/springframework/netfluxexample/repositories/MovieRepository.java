package guru.springframework.netfluxexample.repositories;

import guru.springframework.netfluxexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
/*
 * created by NR on 1 Jul 2019
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
