package raven.modal.demo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory emf;
    private static EntityManager entityManager;

    private EntityManagerFactorySingleton() {
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            if (emf == null)
                emf = Persistence.createEntityManagerFactory("meuPU");

            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }

    public static void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen())
            entityManager.close();

        if (emf != null)
            emf.close();
    }
}
