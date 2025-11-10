package mate.academy.hibernate.relations.dao.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.model.Movie;
import org.hibernate.SessionFactory;

public class MovieDaoImpl extends AbstractDao implements MovieDao {
    public MovieDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Movie add(Movie movie) {
        List<Actor> actors = movie.getActors();
        if (actors != null) {
            actors.forEach(actor -> {
                if (actor.getId() == null) {
                    Country country = actor.getCountry();
                    if (country != null && country.getId() == null) {
                        create(country);
                    }
                    create(actor);
                }
            });
        }
        create(movie);
        return movie;
    }

    @Override
    public Optional<Movie> get(Long id) {
        return find(Movie.class, id);
    }
}
