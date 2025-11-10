package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.dao.impl.MovieDaoImpl;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.MovieService;
import org.hibernate.SessionFactory;

public class MovieServiceImpl implements MovieService {

    private final MovieDao dao;

    public MovieServiceImpl(MovieDao dao) {
        this.dao = dao;
    }

    public MovieServiceImpl(SessionFactory factory) {
        this(new MovieDaoImpl(factory));
    }

    @Override
    public Movie add(Movie movie) {
        return dao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return dao.get(id).orElseThrow();
    }
}
