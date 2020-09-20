import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.util.List;

public class DBConnect {

    public static boolean writeToConsitionsDB(Conditions obj) {

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
            entityManagerFactory.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateConsitionCountDB(Conditions obj) {

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            //entityManager.persist(obj);
            entityManager.getTransaction().commit();
            entityManagerFactory.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean writeFeedbackToDB(Feedback obj) {

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
            entityManagerFactory.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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

//    public static void initializeConditions()
//    {
//
//        JSONParser jsonParser = new JSONParser();
//        try (FileReader file = new FileReader("src/main/resources/InitialConditions.json"))
//        {
//            Object obj = jsonParser.parse(file);
//            JSONArray conditionsList = (JSONArray) obj;
////            conditionsList.forEach( cond -> parseConditions((JSONObject) cond));
//            for (JSONObject jsonobj: conditionsList) {
//                parseConditions(jsonobj);
//            }
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void parseConditions(JSONObject conditions)
//    {
//        Conditions condition = new Conditions();
//        condition.setConditionsDesc((String)(conditions.get("ConditionsDesc")));
//        condition.setConditionsValue((String)conditions.get("ConditionsValue"));
//        condition.setConditionCount(Integer.parseInt(conditions.get("ConditionCount").toString()));
//        writeToConsitionsDB(condition);
//    }
}

