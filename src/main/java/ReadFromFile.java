import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public static List<Feedback> readFromFiles() {

        File docPath = new File("docs");
        File[] commentFiles = docPath.listFiles((d, n) -> n.endsWith(".txt"));

        List<String> feedbackList = new ArrayList<>();
        List<Feedback> feedbacklineitem = new ArrayList<Feedback>();

        if (commentFiles != null) {
            for (File commentFile : commentFiles) {
                feedbackList.addAll(readLineFromFile(commentFile));
            }
        }

        for (String items : feedbackList) {
            feedbacklineitem.add(new Feedback(items));

        }
        return feedbacklineitem;
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
