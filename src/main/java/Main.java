import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String [] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");

        Conditions conditions = new Conditions();
        conditions.setConditionsDesc("TestJava");
        conditions.setConditionsLogic("THaty");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(conditions);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }
}
