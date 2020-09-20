import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentAnalyzer {

    public static void commentConditionAnalyzer() {
        List<Conditions> conditions = DBConnect.readConditionsFromDB();
        List<Feedback> comments = DBConnect.readFeedbackFromDB();

        if (conditions != null) {
            for (Conditions condition : conditions) {
                //System.out.println(condition.getConditionsLogic()+" "+condition.getConditionsValue());
                Pattern pattern = Pattern.compile(condition.getConditionsValue());

                if (comments != null) {
                    for (Feedback comment : comments) {
                        Matcher matcher = pattern.matcher(comment.toString());
                        if (matcher.find()) {
                            condition.setConditionCount(condition.getConditionCount() + 1);
                        }

                    }
                    //System.out.println(condition.getConditionCount());
                    DBConnect.updateConsitionCountDB(condition);
                }
            }
        }



    }
}
