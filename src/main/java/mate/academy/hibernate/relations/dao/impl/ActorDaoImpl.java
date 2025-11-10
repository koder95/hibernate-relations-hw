package mate.academy.hibernate.relations.dao.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.model.Country;
import org.hibernate.SessionFactory;

public class ActorDaoImpl extends AbstractDao implements ActorDao {
    public ActorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Actor add(Actor actor) {
        Country country = actor.getCountry();
        if (country != null && country.getId() == null) {
            create(country);
        }
        create(actor);
        return actor;
    }

    @Override
    public Optional<Actor> get(Long id) {
        return find(Actor.class, id);
    }
}
