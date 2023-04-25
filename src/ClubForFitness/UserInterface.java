
package ClubForFitness;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    
    
    /* Main Method of the class
    */
   public static void main(String args[]){
        
        int choice = menu();
        while (choice != 8)
        {
            switch (choice)
            {
                case 1:
                    checkSchedule();
                    break;
                case 2:
                    getReservations();
                    break;
                case 3:
                    changeReservation();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    attendClass();
                    break;
                case 6:
                    averageRatingReport();
                    break;
                case 7:
                    incomeReport();
                    break;
                default:
                    System.out.println("Please Enter Appropriate Choice");
            }
            choice = menu();
        }
        
    }
   
    /*
    * Function  to check Schedule for lessons
   */
    private static void checkSchedule(){
        
        Scanner userChoice = new Scanner(System.in);

        System.out.println("\nChoose a choice from the menu below.  : ");
        System.out.println("1. According to fitness type [Spin/Yoga/Aquacise/zumba]");
        System.out.println("2. According to Session Time [Morning/Evening]");
        System.out.println("3. According to Daywise [Saturday/Sunday]");
        System.out.print("\nPlease Enter your choice : ");

        String takeInput = userChoice.nextLine();
        while (takeInput.equals("") || !validateString(takeInput))
        {
            System.out.println("Menu choices must be numerical and cannot be left blank.");

            System.out.print("\nPlease Choose the appropriate option to check the schedule : ");

            takeInput = userChoice.nextLine();
        }
        
        int givenChoice = Integer.parseInt(takeInput);
        
        switch (givenChoice)
        {
            case 1 -> scheduleForFitnessType();
            case 2 -> scheduleForSessionTime();
            case 3 -> scheduleForDaywise();
            default -> System.out.println("Please Enter Appropriate Choice");
        }
    }

    /**
     * function to execute if the member wants to find schedule for different fitness types
     */
    private static void scheduleForFitnessType(){
        Scanner userChoice = new Scanner(System.in);

        System.out.println("\nChoose Fitness Type from the menu below.  : ");
        System.out.println("1. Spin");
        System.out.println("2. Yoga");
        System.out.println("3. Aquacise");
        System.out.println("4. Zumba");
        System.out.print("\nPlease Enter your choice : ");

        String takeInput = userChoice.nextLine();
        while (takeInput.equals("") || !validateString(takeInput))
        {
            System.out.println("Menu choices must be numerical and cannot be left blank.");

            System.out.print("\nPlease Choose the appropriate option to check the schedule : ");

            takeInput = userChoice.nextLine();
        }
        
        int givenChoice = Integer.parseInt(takeInput);
        
        //Find Fitness Type against each choice
        String fitnessType = "";
        switch (givenChoice) {
            case 1 -> {
                fitnessType = "Spin";
                getSchedule(fitnessType,"","");
           }
            case 2 -> {
                fitnessType = "Yoga";
                getSchedule(fitnessType,"","");
           }
            case 3 -> {
                fitnessType = "Aquacise";
                getSchedule(fitnessType,"","");
           }
            case 4 -> {
                fitnessType = "Zumba";
                getSchedule(fitnessType,"","");
           }
            default -> System.out.println("\nPlease Enter Appropriate Choice");
        }
                
    }
    
    /**
     * function to execute if the member wants to find schedule for different sessions
     */
    private static void scheduleForSessionTime(){
        Scanner userChoice = new Scanner(System.in);

        System.out.println("\nChoose Session Time from the menu below.  : ");
        System.out.println("1. Morning");
        System.out.println("2. Evening");
        System.out.print("\nPlease Enter your choice : ");

        String takeInput = userChoice.nextLine();
        while (takeInput.equals("") || !validateString(takeInput))
        {
            System.out.println("Menu choices must be numerical and cannot be left blank.");

            System.out.print("\nPlease Choose the appropriate option to check the schedule : ");

            takeInput = userChoice.nextLine();
        }
        
        int givenChoice = Integer.parseInt(takeInput);
        
        //Find Session against each choice
        String session = "";
        switch (givenChoice) {
            case 1 -> {
                session = "Morning";
                getSchedule("","",session);
           }
            case 2 -> {
                session = "Evening";
                getSchedule("","",session);
           }
            default -> System.out.println("\nPlease Enter Appropriate Choice");
        }
    }
    
    
    /**
     * function to execute if the member wants to find schedule for different days
     */
    private static void scheduleForDaywise(){
        Scanner userChoice = new Scanner(System.in);

        System.out.println("\nChoose Weekend Day from the menu below.  : ");
        System.out.println("1. Saturday");
        System.out.println("2. Sunday");
        System.out.print("\nPlease Enter your choice : ");

        String takeInput = userChoice.nextLine();
        while (takeInput.equals("") || !validateString(takeInput))
        {
            System.out.println("Menu choices must be numerical and cannot be left blank.");

            System.out.print("\nPlease Choose the appropriate option to check the schedule : ");

            takeInput = userChoice.nextLine();
        }
        
        int givenChoice = Integer.parseInt(takeInput);
        
        //Find day against each choice
        String day = "";
        switch (givenChoice) {
            case 1 -> {
                day = "saturday";
                getSchedule("",day,"");
           }
            case 2 -> {
                day = "sunday";
                getSchedule("",day,"");
           }
            default -> System.out.println("\nPlease Enter Appropriate Choice");
        }
    }
    
    
    /*
    * Function to ge schedule for "Fitness Type" , "According to Day" or "According to session time"
    */
    private static void getSchedule(String fitnessType,String day, String session){
        
        List<ClubLessons> club_schedule = ClubLessons.club_lessons();
                
        System.out.println("======================================================================================================================");
        System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s%-15s%-2s\n","|","Fitness Type","|","Lesson","|","Day","|","Time","|",
                        "Session","|","Duration","|","Seats Available","|","Lesson Amount","|");
        System.out.println("======================================================================================================================");
        for(int i=0; i<club_schedule.size(); i++){
            int seatsReserved = seatsLeft(club_schedule.get(i).getFitness_lesson());
            int leftSeats = club_schedule.get(i).getSeats_available() - seatsReserved;
            if(!fitnessType.equalsIgnoreCase("")){
                if(club_schedule.get(i).getFitness_type().equalsIgnoreCase(fitnessType)){
                    System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s%-15s%-2s\n","|",club_schedule.get(i).getFitness_type(),"|",club_schedule.get(i).getFitness_lesson(),
                            "|",club_schedule.get(i).getDay(),"|",club_schedule.get(i).getTime(),"|",club_schedule.get(i).getSession_time(),"|",
                            club_schedule.get(i).getClass_duration(),"|",leftSeats,"|","$"+club_schedule.get(i).getPrice(),"|");
                    System.out.println("======================================================================================================================");

                }
            }else if(!day.equalsIgnoreCase("")){
                if(club_schedule.get(i).getDay().equalsIgnoreCase(day)){
                    System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s%-15s%-2s\n","|",club_schedule.get(i).getFitness_type(),"|",club_schedule.get(i).getFitness_lesson(),
                            "|",club_schedule.get(i).getDay(),"|",club_schedule.get(i).getTime(),"|",club_schedule.get(i).getSession_time(),"|",
                            club_schedule.get(i).getClass_duration(),"|",leftSeats,"|","$"+club_schedule.get(i).getPrice(),"|");
                    System.out.println("======================================================================================================================");

                }
            }else if(!session.equalsIgnoreCase("")){
                if(club_schedule.get(i).getSession_time().equalsIgnoreCase(session)){
                    System.out.printf("%-2s%-15s%-2s%-13s%-2s%-13s%-2s%-10s%-2s%-10s%-2s%-10s%-2s%-15s%-2s%-15s%-2s\n","|",club_schedule.get(i).getFitness_type(),"|",club_schedule.get(i).getFitness_lesson(),
                            "|",club_schedule.get(i).getDay(),"|",club_schedule.get(i).getTime(),"|",club_schedule.get(i).getSession_time(),"|",
                            club_schedule.get(i).getClass_duration(),"|",leftSeats,"|","$"+club_schedule.get(i).getPrice(),"|");
                    System.out.println("======================================================================================================================");

                }
            }
        }
        
        choiceForReservation();
    }
    
    
    /**
     * Function to find remaining seats for a lesson
     * @param lesson
     * @return 
     */
    private static int seatsLeft(String lesson){
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        int count = 0;
        
        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getLesson().equalsIgnoreCase(lesson)){
                count += 1;
            }
        }
        return count;
    }
    
    /*
    * Function to take choice for reservations
    */
    private static void choiceForReservation(){
        Scanner userChoice = new Scanner(System.in);

        System.out.println("\nChoose Option from the menu below.  : ");
        System.out.println("1. Reserve Class");
        System.out.println("2. Return to Main Menu");
        System.out.print("\nPlease Enter your choice : ");

        String takeInput = userChoice.nextLine();
        while (takeInput.equals("") || !validateString(takeInput))
        {
            System.out.println("Menu choices must be numerical and cannot be left blank.");

            System.out.print("\nPlease Choose the appropriate option : ");

            takeInput = userChoice.nextLine();
        }
        
        int givenChoice = Integer.parseInt(takeInput);
        
        switch (givenChoice) {
            case 1 -> {
                 reserveClass();
           }
            case 2 -> {
                return;
           }
            default -> System.out.println("\nPlease Enter Appropriate Choice");
        }
        
    }
    
    /**
     * Function to change a reservation
     */
    private static void changeReservation(){
        Scanner userChoice = new Scanner(System.in);
        System.out.print("\nEnter Reservation Code :");
        String reservationCode = userChoice.nextLine();
        
        //Check Reservation Code
        boolean isReservationCodeExists = isReservationCodeExists(reservationCode);
        if(!isReservationCodeExists){
            System.out.println("\nReservation Code entered by you is not valid");
            return;
        }
        
        System.out.print("\nEnter Lesson Name that you want to reserve : ");
        String updated_lesson = userChoice.nextLine();
        
        
        //Display Success Message
        String day = "";
        String time = "";
        String fit_type = "";
        List<ClubLessons> club_lesson = ClubLessons.club_lessons();
        for(int i=0; i<club_lesson.size(); i++){
            if(club_lesson.get(i).getFitness_lesson().equalsIgnoreCase(updated_lesson)){
                day = club_lesson.get(i).getDay();
                time = club_lesson.get(i).getTime();
                fit_type = club_lesson.get(i).getFitness_type();
                club_lesson.get(i).setSeats_available(club_lesson.get(i).getSeats_available());
            }
        }
        
        
        //Update
        String memberName = "";
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        List<ClubMembers> club_members = ClubMembers.club_members();
        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getReservationCode().equalsIgnoreCase(reservationCode)){
                club_reservations.get(i).setLesson(updated_lesson);
                club_reservations.get(i).setLesson(updated_lesson);
                club_reservations.get(i).setFitnessType(fit_type);
                
                for(int j=0; j<club_members.size(); j++){
                     if(club_members.get(j).getMember_code().equalsIgnoreCase(club_reservations.get(i).getReserved_by())){
                         memberName = club_members.get(j).getMember_name();
                     }
                 }
            }
        }
        

        

        System.out.println("\n=====================================================================================================");
        System.out.println("Success Message :");
        System.out.println("Successfully Changed Lesson '"+updated_lesson+"' on "+day+" at "+time+ " for member '"+memberName+"'");
        System.out.println("=====================================================================================================");
        
    }
    
    
    /**
     * Function to cancel a reservation
     */
    private static void cancelReservation(){
        Scanner userChoice = new Scanner(System.in);
        System.out.print("\nEnter Reservation Code :");
        String reservationCode = userChoice.nextLine();
        
        Command cancelReservationCommand = new CancelReservationCmdClass(reservationCode);
        cancelReservationCommand.executeFunction();
       
    }
       
    
    
    
    /**
     * Function to check reservation code existence
     */
    public static boolean isReservationCodeExists(String reservationCode){
        boolean isExist = false;
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getReservationCode().equalsIgnoreCase(reservationCode)){
                isExist = true;
            }
        }
        return isExist;
    }
    
    
    /**
     * Function to reserve class for customer
     */
    private static void reserveClass(){
        Scanner userChoice = new Scanner(System.in);
        System.out.print("\nCopy and Paste Lesson which you want to reserve from a list of above lesson : ");
        String lesson = userChoice.nextLine();
        
        //Check lesson exists or not
        boolean isLessonExist = isLessonExist(lesson);
        if(!isLessonExist){
            System.out.println("\nThe list of club fitness lessons does not include the given lesson.");
            return;
        }
        
        //If No seat available
        int seatsReserved = seatsLeft(lesson);
        int leftSeats = ClubReservations.MAX_SEATS - seatsReserved;
        if(leftSeats == 0){
            System.out.println("\nSorry! No Seat Available for the given lesson.");
            return;
        }
                   
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMM,yyyy");
        
        //Take Member detail to make reservation
        System.out.print("\nPlease Enter Your Name : ");
        String memberName = userChoice.nextLine();
        
        //Is member exist or not
        String code = isMemberExist(memberName);
        if(code.equalsIgnoreCase("")){
            String registeredOn = currentDate.format(formatter);
             //Generate Member Code
            code = generateMemberCode();

            //Add member
            ClubMembers club_member = new ClubMembers(code,memberName,registeredOn);
            ClubMembers.club_members.add(club_member);
        }
        
        //If member reserves same lesson twice
        boolean isReservingSameLesson = isReservingSameLesson(lesson,code);    
        if(isReservingSameLesson){
           System.out.println("\nYou are trying to reserve same lesson again");
           return;
        }
        
        //Get lesson fitness type
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
        
        
        //Make Reservation
        //generate reservation code 
        String reservationCode = generateReservationCode();
        String reservedOn = currentDate.format(formatter);
        ClubReservations club_reservations = new ClubReservations(reservationCode, fit_type,lesson,reservedOn,code,ClubReservations.BOOK);
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
    
    
    /**
     * Function to check whether the member is reserving same lesson
     */
    public static boolean isReservingSameLesson(String lesson,String mcode){
        boolean isSame = false;
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getLesson().equalsIgnoreCase(lesson) &&
                    club_reservations.get(i).getReserved_by().equalsIgnoreCase(mcode)){
                isSame = true;
            }
        }
        return isSame;
    }
    
    /**
     * Function to check member exists or not
     */
    
    private static String isMemberExist(String memberName){
        String code = "";
        List<ClubMembers> club_members = ClubMembers.club_members();
        for(int i=0; i<club_members.size(); i++){
            if(club_members.get(i).getMember_name().equalsIgnoreCase(memberName)){
                code = club_members.get(i).getMember_code();
            }
        }
        return code;
    }
    
    
    /**
     * Function to generate reservation code
     * @return 
     */
    public static String generateReservationCode(){
        String code = "";
        Random random = new Random();
        int randomNo = random.nextInt(9000) + 1000;
        code = "ClubBNo_"+randomNo;
        return code;
    }
    
    
    
    /**
     * Generate member code 
     * @return generated member code
     */
    private static String generateMemberCode(){
        Random random = new Random();
        int randomNo = random.nextInt(90000) + 10000;
        String mcode = "MCode_"+randomNo;
        return mcode;
    }
    
    
    /*
    * Function to get all reservations
    */
    private static void getReservations(){
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        List<ClubMembers> club_members = ClubMembers.club_members();
        int count = 1;
        
        for(int i=0; i<club_reservations.size(); i++){
            System.out.println("\n=========================================================");
            System.out.println("\nBooking Record : "+count);
            System.out.println("Booking Code : "+club_reservations.get(i).getReservationCode());
            System.out.println("Lesson : "+club_reservations.get(i).getLesson());
            System.out.println("Reserved On : "+club_reservations.get(i).getReserved_on());
            System.out.println("Reservation Status : "+club_reservations.get(i).getReservation_status());
            
            //Members details
            String name = "";
            String mcode = "";
            String registeredOn = "";
            for(int j=0; j<club_members.size(); j++){
                if(club_members.get(j).getMember_code().equalsIgnoreCase(club_reservations.get(i).getReserved_by())){
                    name = club_members.get(j).getMember_name();
                    mcode = club_members.get(j).getMember_code();
                    registeredOn = club_members.get(j).getMember_registered_on();
                }
            }
            
            System.out.println("\nMember Details : ");
            System.out.println("Member Code : "+mcode);
            System.out.println("Member Name : "+name);
            System.out.println("Registered On : "+registeredOn);
            System.out.println("\n=========================================================");
            count += 1;
        }
    }
    
    
    /**
     * Function to check whether the given lesson exist in the list of club fitness lessons
     * @param lesson
     * @return 
     */
    private static boolean isLessonExist(String lesson){
        boolean isLessonExist = false;
        
        List<ClubLessons> club_lessons = ClubLessons.club_lessons();
        for(int i=0; i<club_lessons.size(); i++){
            if(club_lessons.get(i).getFitness_lesson().equalsIgnoreCase(lesson)){
                isLessonExist = true;
            }
        }
        return isLessonExist;
    }
    
    
    
    /**
     * Function to attend class i.e. add feedback for the lesson
     */
    private static void attendClass(){
        Scanner userChoice = new Scanner(System.in);
        System.out.print("\nEnter Reservation Code :");
        String reservationCode = userChoice.nextLine();
        
        //Check Reservation Code
        boolean isReservationCodeExists = isReservationCodeExists(reservationCode);
        if(!isReservationCodeExists){
            System.out.println("\nReservation Code entered by you is not valid");
            return;
        }
                
        //Is Already Attended class
        boolean isAttendedOrCancelled = isAttendedOrCancelled(reservationCode);
        if(isAttendedOrCancelled){
            System.out.println("\nSorry! You can't attend class which is already attended or cancelled by you");
            return;
        }
        
        System.out.print("\nEnter Feedback for lesson : ");
        String anyFeedback = userChoice.nextLine();
        
        System.out.println("\n-----------------------------------");
        System.out.printf("%-2s%-20s%-2s%-10s%-2s\n","|","Feebback","|","Ratings","|");
        System.out.println("-----------------------------------");
        System.out.printf("%-2s%-20s%-2s%-10s%-2s\n","|","Very Dissatisfied","|","1","|");
        System.out.printf("%-2s%-20s%-2s%-10s%-2s\n","|","Dissatisfied","|","2","|");
        System.out.printf("%-2s%-20s%-2s%-10s%-2s\n","|","OK","|","3","|");
        System.out.printf("%-2s%-20s%-2s%-10s%-2s\n","|","Satisfied","|","4","|");
        System.out.printf("%-2s%-20s%-2s%-10s%-2s\n","|","Very Satisfied","|","5","|");
        System.out.println("-----------------------------------");

        
        System.out.print("\n\nEnter Rating between 1 to 5 : ");
        String rating = userChoice.nextLine();
        
        //Get Reservation details
        String feedbackBy = "";
        String lessonFor = "";
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        for(int i=0; i<club_reservations.size(); i++){
            feedbackBy = club_reservations.get(i).getReserved_by();
            lessonFor = club_reservations.get(i).getLesson();
        }
        ClubFeedbacks cf = new ClubFeedbacks(lessonFor,anyFeedback,rating,feedbackBy);
        ClubFeedbacks.club_feedbacks.add(cf);
        
        //Update Status to Attended
        updateStatusAttended(reservationCode);
        
        System.out.println("\nWe appreciate your feedback on the lesson.Your opinions are valuable to us.");
        return;
    }
    
    
    /**
     * Update reservation status to attended
     * @param reservationCode 
     */
    private static void updateStatusAttended(String reservationCode){
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getReservationCode().equalsIgnoreCase(reservationCode)){
                club_reservations.get(i).setReservation_status(ClubReservations.ATTEND);
            }
        }
    }
    
    
    
    /*
    * Function to check if the member has already attended or cancelled class
    */
    private static boolean isAttendedOrCancelled(String reservationCode){
        boolean isAttendedOrCancelled = false;
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        for(int i=0; i<club_reservations.size(); i++){
            if(club_reservations.get(i).getReservationCode().equalsIgnoreCase(reservationCode)
                    && club_reservations.get(i).getReservation_status().equalsIgnoreCase(ClubReservations.ATTEND) 
                    || club_reservations.get(i).getReservation_status().equalsIgnoreCase(ClubReservations.CANCEL)){
                isAttendedOrCancelled = true;
            }
        }
        return isAttendedOrCancelled;
    }
    
    
    /**
     * Function to find average rating report for each lesson
     */
    private static void averageRatingReport(){
        Scanner userChoice = new Scanner(System.in);
        System.out.print("\nEnter Month Number between 1 to 12 to generate report for that month :");
        String reportMonth = userChoice.nextLine();
        
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        List<ClubLessons> club_lessons = ClubLessons.club_lessons();
        List<ClubFeedbacks> club_feedbacks = ClubFeedbacks.club_feedbacks();
        
        int tol_members = 0;
        int no_of_feedback = 0;
        int total_feedback = 0;
        
        String reservedLeson = "";
        String club_lesson = "";
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.printf("%-2s%-8s%-2s%-10s%-2s%-10s%-2s%-17s%-2s\n", "|","S.No.","|","Lesson", "|","Customers","|", "Average Ratings","|");
        System.out.println("------------------------------------------------------");
        for(int i=0; i<club_lessons.size(); i++){
            
            //Get Number of customer who booked a lesson
            for(int j=0; j<club_reservations.size(); j++){
                
                String reserved_month = club_reservations.get(j).getReserved_on();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMMM,yyyy");  
                LocalDate localDate = LocalDate.parse(reserved_month, dateFormat);
                int reservedMonth = localDate.getMonthValue();
                
                if(club_lessons.get(i).getFitness_lesson().equalsIgnoreCase(club_reservations.get(j).getLesson())
                        && reservedMonth == Integer.parseInt(reportMonth)){
                    tol_members = tol_members + 1;
                    reservedLeson = club_reservations.get(j).getLesson();
                }               
            }
            
            //Average Rating
            for(int k=0; k<club_feedbacks.size(); k++){
                    
                if(club_lessons.get(i).getFitness_lesson().equalsIgnoreCase(club_feedbacks.get(k).getLesson())){
                    no_of_feedback = no_of_feedback + 1;
                    total_feedback = total_feedback + Integer.parseInt(club_feedbacks.get(k).getRating());
                    club_lesson = club_feedbacks.get(k).getLesson();
                }
            }
            
            if(!club_lessons.get(i).getFitness_lesson().equalsIgnoreCase(reservedLeson)){
                tol_members = 0;
            }
            
            if(!club_lessons.get(i).getFitness_lesson().equalsIgnoreCase(club_lesson)){
                no_of_feedback = 0;
                total_feedback = 0;
            }
            double member_feedbacks = 0.0;
            if(no_of_feedback != 0){
                member_feedbacks = total_feedback/no_of_feedback;
            }else{
                member_feedbacks = 0;
            }
            
            System.out.printf("%-2s%-8s%-2s%-10s%-2s%-10s%-2s%-17s%-2s\n", "|",(i+1),"|",club_lessons.get(i).getFitness_lesson(),"|",tol_members, "|",member_feedbacks,"|");
        }
        System.out.print("------------------------------------------------------\n");
    }
    
    
    /**
     * Function to find income report for each fitness type
     */
    private static void incomeReport(){
        Scanner userChoice = new Scanner(System.in);
        System.out.print("\nEnter Month Number between 1 to 12 to generate report for that month :");
        String reportMonth = userChoice.nextLine();
        
        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        List<ClubLessons> club_lessons = ClubLessons.club_lessons();
        ArrayList<ClubReservations> club_reservations_dummy = new ArrayList<>();
        club_reservations_dummy.addAll(club_reservations);
        System.out.println();
        System.out.println("--------------------------------");

        System.out.printf("%-2s%-15s%-2s%-12s%-2s\n", "|","Fitness Type", "|","Income","|");
        System.out.println("--------------------------------");
         

        Map<String, Double> findIncForClassTypes = new HashMap<>();                                 

        for(int i = 0; i < club_lessons.size(); i++) {
            String fit_type = null;
            double tot_income = 0.0;
            for(int x = 0; x < club_reservations_dummy.size(); x++) {      
                
                String reserved_month = club_reservations_dummy.get(x).getReserved_on();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMMM,yyyy");  
                LocalDate localDate = LocalDate.parse(reserved_month, dateFormat);
                int reservedMonth = localDate.getMonthValue();
    
                if(club_lessons.get(i).getFitness_type().equalsIgnoreCase(club_reservations_dummy.get(x).getFitnessType()) 
                        && reservedMonth == Integer.parseInt(reportMonth)
                        && club_reservations_dummy.get(x).getReservation_status().equalsIgnoreCase(ClubReservations.ATTEND)) {
                    
                    tot_income += club_lessons.get(i).getPrice();
                    fit_type = club_reservations_dummy.get(x).getFitnessType();
                    club_reservations_dummy.remove(x); 
                    x--; 
                }
            }
            
            if(fit_type != null) {
                findIncForClassTypes.merge(fit_type, tot_income, Double::sum);
            }            
        }
        findIncForClassTypes.forEach((fit_types, income) -> {
             System.out.printf("%-2s%-15s%-2s$%-11s%-2s\n","|",fit_types,"|",income,"|");

        });
        System.out.print("--------------------------------\n");
    }
    
    
    /**
     * Show menu options to user
     * @return selected choice
    */
    private static int menu(){     
        Scanner userChoice = new Scanner(System.in);

        System.out.println("\nChoose a choice from the menu below.  : ");
        System.out.println("1. Club Schedule & Make Reserve");
        System.out.println("2. Reservations");
        System.out.println("3. Change a Reservation");
        System.out.println("4. Cancel Reservation");
        System.out.println("5. Attend Class");
        System.out.println("6. Lesson Average Rating Report");
        System.out.println("7. Income Report");
        System.out.println("8. Exit the application");
        System.out.print("\nEnter your choice : ");

        String takeInput = userChoice.nextLine();
        while (takeInput.equals("") || !validateString(takeInput))
        {
            System.out.println("Menu choices must be numerical and cannot be left blank.");

            System.out.print("\nPlease Choose the appropriate option to carry out the necessary actions : ");

            takeInput = userChoice.nextLine();
        }
        return Integer.parseInt(takeInput);
    }
    
    
    
    /**
     * Method to take only numerical values from user
     * @param str
     * @return 
     */
    private static boolean validateString(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
