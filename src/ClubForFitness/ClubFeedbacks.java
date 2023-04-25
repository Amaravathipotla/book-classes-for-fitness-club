
package ClubForFitness;

import java.util.ArrayList;
import java.util.List;


public class ClubFeedbacks {
    
    private String lesson;
    private String feedback;
    private String rating;
    private String feedback_by;

    public static ArrayList <ClubFeedbacks> club_feedbacks = new ArrayList<>();

    public ClubFeedbacks(String lesson, String feedback, String rating, String feedback_by) {
        this.lesson = lesson;
        this.feedback = feedback;
        this.rating = rating;
        this.feedback_by = feedback_by;
    }

    public String getLesson() {
        return lesson;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getRating() {
        return rating;
    }

    public String getFeedback_by() {
        return feedback_by;
    }
    
     
    public static  List<ClubFeedbacks> club_feedbacks(){
        return club_feedbacks;
    }
}
