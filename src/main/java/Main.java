import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ikhokhaPersistence");



        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Conditions conditions = new Conditions();
        conditions.setConditionsDesc("Less than 15");
        conditions.setConditionsLogic("<");
        conditions.setConditionsValue("15");

        entityManager.persist(conditions);
//   		File docPath = new File("docs");
//		File[] commentFiles = docPath.listFiles((d, n) -> n.endsWith(".txt"));
//
//		List<String> feedbackList = new ArrayList<>();
//
//		for (File commentFile : commentFiles) {
//			feedbackList.addAll(readLineFromFile(commentFile));
//		}
//
//        for (String items : feedbackList) {
//            Feedback feedbacklineitem = new Feedback();
//            feedbacklineitem.setFeedbackDesc(items);
//            entityManager.persist(feedbacklineitem);
//
//
//        }
        entityManager.getTransaction().commit();
        entityManagerFactory.close();


    }

    public static List<String> readLineFromFile(File file )
    {
        List<String> lineList = new ArrayList<>();
        Feedback feedbackItem = new Feedback();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            while ((line = reader.readLine()) != null)
//                feedbackItem.setFeedbackDesc(line);
                lineList.add(line);

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("IO Error processing file: " + file.getAbsolutePath());
            e.printStackTrace();
        }
        return lineList;
    }
}
