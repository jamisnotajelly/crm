package db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(JPAUtil.class);
    private static final String PERSISTENCE_UNIT_NAME = "crm-unit";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        LOGGER.info("Starting EntityManagerFactory initialization");
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        LOGGER.info("EntityManagerFactory initialization complete");
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}