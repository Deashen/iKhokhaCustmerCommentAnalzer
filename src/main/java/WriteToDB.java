import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteToDB {

    public static boolean writeToConsitionsDB(Conditions obj) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return true;
    }

    public static boolean writeFeedbackToDB(Feedback obj) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return true;
    }

    public static List<Feedback> readFeedbackFromDB() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Feedback> feedback = entityManager.createQuery("SELECT f FROM Feedback f", Feedback.class).getResultList();
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return feedback;
    }

    public static List<Conditions> readConditionsFromDB() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Conditions> conditions = entityManager.createQuery("SELECT c FROM Conditions c", Conditions.class).getResultList();
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
        return conditions;
    }
}

