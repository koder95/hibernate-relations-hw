package mate.academy.hibernate.relations.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure()
                .buildSessionFactory();
    }
}
