import java.util.List;

public class Main {

    public static void main(String [] args)
    {

//        List<Feedback> objs = ReadFromFile.readFromFiles();
//
//        for (Feedback obj: objs) {
//            DBConnect.writeFeedbackToDB(obj);
//        }
//
//        List<Feedback> comments = DBConnect.readFeedbackFromDB();
//
//        if (comments!=null)
//        {
//            for (Feedback comment: comments) {
//                System.out.println(comment);
//            }
//        }

        List<Conditions> conditions = DBConnect.readConditionsFromDB();

        if (conditions!=null)
        {
            for (Conditions condition: conditions) {
                System.out.println(condition.getConditionsLogic()+" "+condition.getConditionsValue());
            }
        }

    }

}
