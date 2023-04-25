
import ClubForFitness.ClubLessons;
import ClubForFitness.ClubMembers;
import ClubForFitness.ClubReservations;
import ClubForFitness.UserInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestFile {
    
   
    @Test
    public void fitnessTypeSchedule() {
        List<ClubLessons> club_schedule = ClubLessons.club_lessons();
                
        String fitnessType = "zumba";
        
        System.out.println("\nTest Case - Schedule for Fitness Type : "+fitnessType+"\n\n");
        System.out.println("=====================================================================================================");
        System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s\n","|","Fitness Type","|","Lesson","|","Day","|","Time","|",
                        "Session","|","Duration","|","Lesson Amount","|");
        System.out.println("=====================================================================================================");
        for(int i=0; i<club_schedule.size(); i++){
            if(!fitnessType.equalsIgnoreCase("")){
                if(club_schedule.get(i).getFitness_type().equalsIgnoreCase(fitnessType)){
                    System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s\n","|",club_schedule.get(i).getFitness_type(),"|",club_schedule.get(i).getFitness_lesson(),
                            "|",club_schedule.get(i).getDay(),"|",club_schedule.get(i).getTime(),"|",club_schedule.get(i).getSession_time(),"|",
                            club_schedule.get(i).getClass_duration(),"|","$"+club_schedule.get(i).getPrice(),"|");
                    System.out.println("=====================================================================================================");

                }
            }
        }
    }
    
    
    @Test
    public void daywiseSchedule() {
        List<ClubLessons> club_schedule = ClubLessons.club_lessons();
                
        String day = "sunday";
        
        System.out.println("\nTest Case - Schedule for Day : "+day+"\n\n");
        System.out.println("=====================================================================================================");
        System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s\n","|","Fitness Type","|","Lesson","|","Day","|","Time","|",
                        "Session","|","Duration","|","Lesson Amount","|");
        System.out.println("=====================================================================================================");
        for(int i=0; i<club_schedule.size(); i++){
            if(!day.equalsIgnoreCase("")){
                if(club_schedule.get(i).getDay().equalsIgnoreCase(day)){
                    System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s\n","|",club_schedule.get(i).getFitness_type(),"|",club_schedule.get(i).getFitness_lesson(),
                            "|",club_schedule.get(i).getDay(),"|",club_schedule.get(i).getTime(),"|",club_schedule.get(i).getSession_time(),"|",
                            club_schedule.get(i).getClass_duration(),"|","$"+club_schedule.get(i).getPrice(),"|");
                    System.out.println("=====================================================================================================");

                }
            }
        }
    }
    
    
    
    @Test
    public void reserve(){
        System.out.println("\nTest Case - Reserve Class \n\n");
        
        String lesson = "spin1";
        String memberName = "Kelly";
       
        String day = "";
        String time = "";
        String fit_type = "";
        List<ClubLessons> club_lesson = ClubLessons.club_lessons();
        for(int i=0; i<club_lesson.size(); i++){
            if(club_lesson.get(i).getFitness_lesson().equalsIgnoreCase(lesson)){
                day = club_lesson.get(i).getDay();
                time = club_lesson.get(i).getTime();
                fit_type = club_lesson.get(i).getFitness_type();
                club_lesson.get(i).setSeats_available(club_lesson.get(i).getSeats_available());
            }
        }
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMM,yyyy");
        //generate reservation code 
        String reservationCode = UserInterface.generateReservationCode();
        String reservedOn = currentDate.format(formatter);
        ClubReservations club_reservations = new ClubReservations(reservationCode, fit_type,lesson,reservedOn,reservationCode,ClubReservations.BOOK);
        ClubReservations.club_reservations.add(club_reservations);
        
        
        //Update Number of seats for lesson
        for(int i=0; i<club_lesson.size(); i++){
            if(club_lesson.get(i).getFitness_lesson().equalsIgnoreCase(lesson)){
                day = club_lesson.get(i).getDay();
                time = club_lesson.get(i).getTime();
                club_lesson.get(i).setSeats_available(club_lesson.get(i).getSeats_available());
            }
        }
        
        System.out.println("\n=====================================================================================================");
        System.out.println("Success Message :");
        System.out.println("Successfully Booked Lesson '"+lesson+"' on "+day+" at "+time+ " for member '"+memberName+"'");
        System.out.println("Your Reservation Code is "+reservationCode);
        System.out.println("=====================================================================================================");
    }
    
    
     @Test
    public void cancel() {
        System.out.println("\nTest Case - Cancel Class \n\n");
        
        String reservationCode = "ClubBNo_3113";
        ClubReservations club_reservations_obj = new ClubReservations(reservationCode, "spin","spin1","20April,2023",reservationCode,
                ClubReservations.BOOK);
        ClubReservations.club_reservations.add(club_reservations_obj);
        
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        String day = "";
        String lesson = "";
        String time = "";
        String memberName = "Kelly";
        List<ClubLessons> club_lesson = ClubLessons.club_lessons();
        List<ClubMembers> club_members = ClubMembers.club_members();

        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getReservationCode().equalsIgnoreCase(reservationCode)){
                club_reservations.get(i).setReservation_status(ClubReservations.CANCEL);
                 for(int j=0; j<club_lesson.size(); j++){
                    if(club_lesson.get(j).getFitness_lesson().equalsIgnoreCase(club_reservations.get(i).getLesson())){
                        day = club_lesson.get(i).getDay();
                        time = club_lesson.get(i).getTime();
                        lesson = club_lesson.get(i).getFitness_lesson();
                        club_lesson.get(i).setSeats_available(club_lesson.get(i).getSeats_available());
                    }
                }
                 
                for(int j=0; j<club_members.size(); j++){
                    if(club_members.get(j).getMember_code().equalsIgnoreCase(club_reservations.get(i).getReserved_by())){
                        memberName = club_members.get(j).getMember_name();
                    }
                }
            }
        }
        
        //Display Success Message
        System.out.println("\n=====================================================================================================");
        System.out.println("Success Message :");
        System.out.println("Successfully Cancelled Lesson '"+lesson+"' on "+day+" at "+time+ " for member '"+memberName+"'");
        System.out.println("=====================================================================================================");
    }
    
    
    
    @Test
    public void checkReservationCodeValid() {
        System.out.println("\nTest Case - Check reservation Code Valid \n\n");
        
        String reservationCode = "ClubBNo_3223";
        ClubReservations club_reservations_obj = new ClubReservations(reservationCode, "spin","spin1","20April,2023","MCode_98745",
                ClubReservations.BOOK);
        ClubReservations.club_reservations.add(club_reservations_obj);
        
        
        boolean isValid = UserInterface.isReservationCodeExists("ClubBNo_3223");
        if(!isValid){
            System.out.println("\nReservation Code entered by you is not valid");
        }else{
            System.out.println("\nReservation Code entered by you is valid");
        }
        
    }
    
    
    
     @Test
    public void dontReserveSameLesson() {
        System.out.println("\nTest Case - Member Cannot Reserve Same Lesson Twice\n\n");
        
        String lesson = "spin1";
        String reservationCode = "ClubBNo_1823";
        ClubReservations club_reservations_obj = new ClubReservations(reservationCode, "spin",lesson,"20April,2023","MCode_98745",
                ClubReservations.BOOK);
        ClubReservations.club_reservations.add(club_reservations_obj);
        
        
        boolean isReservingSameLesson = UserInterface.isReservingSameLesson(lesson,"MCode_98745");
         if(isReservingSameLesson){
            System.out.println("\nYou are trying to reserve same lesson again");
        }
        
    }
    
    
    
}
