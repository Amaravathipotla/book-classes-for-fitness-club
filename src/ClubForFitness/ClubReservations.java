
package ClubForFitness;

import java.util.ArrayList;
import java.util.List;

public class ClubReservations {
    
    private String reservationCode;
    private String fitnessType;
    private String lesson;
    private String reserved_on;
    private String reserved_by;
    private String reservation_status;
    
    public static final String BOOK = "Booked";
    public static final String CHANGE = "Changed";
    public static final String CANCEL = "Cancelled";
    public static final String ATTEND = "Attended";
    public static final int MAX_SEATS = 5;

    public static ArrayList <ClubReservations> club_reservations = new ArrayList<>();

    public ClubReservations(String reservationCode, String fitnessType,String lesson, String reserved_on, String reserved_by, String reservation_status) {
        this.reservationCode = reservationCode;
        this.fitnessType = fitnessType;
        this.lesson = lesson;
        this.reserved_on = reserved_on;
        this.reserved_by = reserved_by;
        this.reservation_status = reservation_status;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public String getLesson() {
        return lesson;
    }

    public String getReserved_on() {
        return reserved_on;
    }

    public String getReserved_by() {
        return reserved_by;
    }

    public String getReservation_status() {
        return reservation_status;
    }

    public String getFitnessType() {
        return fitnessType;
    }

    
    
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void setReservation_status(String reservation_status) {
        this.reservation_status = reservation_status;
    }

    public void setFitnessType(String fitnessType) {
        this.fitnessType = fitnessType;
    }

   
    
    public static  List<ClubReservations> club_reservations(){
        return club_reservations;
    }
}
