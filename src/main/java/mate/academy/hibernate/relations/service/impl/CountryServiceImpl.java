package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.dao.impl.CountryDaoImpl;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.service.CountryService;
import org.hibernate.SessionFactory;

public class CountryServiceImpl implements CountryService {

    private final CountryDao dao;

    public CountryServiceImpl(CountryDao dao) {
        this.dao = dao;
    }

    public CountryServiceImpl(SessionFactory factory) {
        this(new CountryDaoImpl(factory));
    }

    @Override
    public Country add(Country country) {
        return dao.add(country);
    }

    @Override
    public Country get(Long id) {
        return dao.get(id).orElseThrow();
    }
}
