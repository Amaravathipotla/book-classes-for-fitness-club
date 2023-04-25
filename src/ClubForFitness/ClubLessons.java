
package ClubForFitness;

import java.util.ArrayList;
import java.util.List;



public class ClubLessons {
    
    private String fitness_type;
    private String fitness_lesson;
    private String day;
    private String time;
    private int price;
    private String class_duration;
    private String session_time;
    private int seats_available;
    
    
    public static ArrayList <ClubLessons> club_lessons = new ArrayList<>();


    public ClubLessons(String fitness_type, String fitness_lesson, String day, String time, String class_duration, String session_time, int seats_available, int price) {
        this.fitness_type = fitness_type;
        this.fitness_lesson = fitness_lesson;
        this.day = day;
        this.time = time;
        this.class_duration = class_duration;
        this.session_time = session_time;
        this.seats_available = seats_available;
        this.price = price;
    }

    public String getFitness_type() {
        return fitness_type;
    }

    public String getFitness_lesson() {
        return fitness_lesson;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public int getSeats_available() {
        return seats_available;
    }

    public String getClass_duration() {
        return class_duration;
    }

    public String getSession_time() {
        return session_time;
    }

    public int getPrice() {
        return price;
    }

    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available - 1;
    }
    
    public static  List<ClubLessons> club_lessons(){
        club_lessons.removeAll(club_lessons);
        pre_registered_lessons();
        return club_lessons;
    }
    
    
    public static void pre_registered_lessons(){
        ClubLessons c1 = new ClubLessons("spin","spin1","sunday","10am","2 hours","Evening",5,20);
        ClubLessons c2 = new ClubLessons("spin","spin2","saturday","11am","3 hours","Morning",5,20);
        ClubLessons c3 = new ClubLessons("spin","spin3","sunday","09am","2 hours","Morning",5,20);
        ClubLessons c4 = new ClubLessons("spin","spin4","saturday","10:30am","3 hours","Morning",5,20);
        ClubLessons c5 = new ClubLessons("spin","spin5","sunday","11:30am","2 hours","Evening",5,20);
        ClubLessons c6 = new ClubLessons("spin","spin6","saturday","09:20am","4 hours","Morning",5,20);
        ClubLessons c7 = new ClubLessons("spin","spin7","sunday","10:10am","2 hours","Evening",5,20);
        ClubLessons c8 = new ClubLessons("spin","spin8","saturday","11:10am","3 hours","Morning",5,20);
        
        ClubLessons c9 = new ClubLessons("yoga","yoga1","sunday","07:30am","2 hours","Morning",5,35);
        ClubLessons c10 = new ClubLessons("yoga","yoga2","saturday","08:20am","2 hours","Morning",5,35);
        ClubLessons c11 = new ClubLessons("yoga","yoga3","sunday","07:50am","3 hours","Evening",5,35);
        ClubLessons c12 = new ClubLessons("yoga","yoga4","saturday","09:30am","2 hours","Morning",5,35);
        ClubLessons c13 = new ClubLessons("yoga","yoga5","sunday","10:15am","3 hours","Morning",5,35);
        ClubLessons c14 = new ClubLessons("yoga","yoga6","saturday","11:05am","2 hours","Morning",5,35);
        ClubLessons c15 = new ClubLessons("yoga","yoga7","sunday","11:40am","3 hours","Evening",5,35);
        ClubLessons c16 = new ClubLessons("yoga","yoga8","saturday","11:55am","2 hours","Morning",5,35);
        
        ClubLessons c17 = new ClubLessons("aquacise","aquacise1","sunday","09:45am","2 hours","Morning",5,28);
        ClubLessons c18 = new ClubLessons("aquacise","aquacise2","saturday","09:15am","3 hours","Evening",5,28);
        ClubLessons c19 = new ClubLessons("aquacise","aquacise3","sunday","09:25am","2 hours","Morning",5,28);
        ClubLessons c20 = new ClubLessons("aquacise","aquacise4","saturday","07:40am","3 hours","Evening",5,28);
        ClubLessons c21 = new ClubLessons("aquacise","aquacise5","sunday","08:05am","2 hours","Morning",5,28);
        ClubLessons c22 = new ClubLessons("aquacise","aquacise6","saturday","08:15am","3 hours","Evening",5,28);
        ClubLessons c23 = new ClubLessons("aquacise","aquacise7","sunday","09:35am","2 hours","Morning",5,28);
        ClubLessons c24 = new ClubLessons("aquacise","aquacise8","saturday","05:10pm","3 hours","Evening",5,28);
        
        
        ClubLessons c25 = new ClubLessons("zumba","zumba1","sunday","04:30pm","2 hours","Evening",5,32);
        ClubLessons c26 = new ClubLessons("zumba","zumba2","saturday","05:15pm","3 hours","Morning",5,32);
        ClubLessons c27 = new ClubLessons("zumba","zumba3","sunday","06:30pm","2 hours","Evening",5,32);
        ClubLessons c28 = new ClubLessons("zumba","zumba4","saturday","06:30pm","3 hours","Evening",5,32);
        ClubLessons c29 = new ClubLessons("zumba","zumba5","sunday","04:50pm","2 hours","Morning",5,32);
        ClubLessons c30 = new ClubLessons("zumba","zumba6","saturday","05:30pm","3 hours","Evening",5,32);
        ClubLessons c31 = new ClubLessons("zumba","zumba7","sunday","06:40pm","2 hours","Morning",5,32);
        ClubLessons c32 = new ClubLessons("zumba","zumba8","saturday","05:40pm","3 hours","Morning",5,32);
        
        
        ClubLessons.club_lessons.add(c1);
        ClubLessons.club_lessons.add(c2);
        ClubLessons.club_lessons.add(c3);
        ClubLessons.club_lessons.add(c4);
        ClubLessons.club_lessons.add(c5);
        ClubLessons.club_lessons.add(c6);
        ClubLessons.club_lessons.add(c7);
        ClubLessons.club_lessons.add(c8);
        ClubLessons.club_lessons.add(c9);
        ClubLessons.club_lessons.add(c10);
        ClubLessons.club_lessons.add(c11);
        ClubLessons.club_lessons.add(c12);
        ClubLessons.club_lessons.add(c13);
        ClubLessons.club_lessons.add(c14);
        ClubLessons.club_lessons.add(c15);
        ClubLessons.club_lessons.add(c16);
        ClubLessons.club_lessons.add(c17);
        ClubLessons.club_lessons.add(c18);
        ClubLessons.club_lessons.add(c19);
        ClubLessons.club_lessons.add(c20);
        ClubLessons.club_lessons.add(c21);
        ClubLessons.club_lessons.add(c22);
        ClubLessons.club_lessons.add(c23);
        ClubLessons.club_lessons.add(c24);
        ClubLessons.club_lessons.add(c25);
        ClubLessons.club_lessons.add(c26);
        ClubLessons.club_lessons.add(c27);
        ClubLessons.club_lessons.add(c28);
        ClubLessons.club_lessons.add(c29);
        ClubLessons.club_lessons.add(c30);
        ClubLessons.club_lessons.add(c31);
        ClubLessons.club_lessons.add(c32);
    }

}
