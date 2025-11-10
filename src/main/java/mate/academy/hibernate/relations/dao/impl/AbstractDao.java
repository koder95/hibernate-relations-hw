package mate.academy.hibernate.relations.dao.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.dao.DataProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDao {
    protected final SessionFactory factory;

    protected AbstractDao(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    protected void create(Object obj) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Cannot add to DB: " + obj, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    protected <T> Optional<T> find(Class<T> entityType, Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.find(entityType, id));
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find id: " + id + " [" + entityType + "]", e);
        }
    }
}
