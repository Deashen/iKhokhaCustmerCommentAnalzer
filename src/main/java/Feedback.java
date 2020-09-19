import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Feedback")
public class Feedback {

    public Feedback(String feedbackDesc)
    {
        setFeedbackDesc(feedbackDesc);
    }

    public Feedback()
    {

    }

    @Id
    @Column(name="idFeedback")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int idFeedback;

    @Column(name = "FeedbackDesc", nullable = false)
    private String FeedbackDesc;

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getFeedbackDesc() {
        return FeedbackDesc;
    }

    public void setFeedbackDesc(String feedbackDesc) {
        FeedbackDesc = feedbackDesc;
    }

    @Override
    public String toString() {
        return FeedbackDesc+"";
    }
}
