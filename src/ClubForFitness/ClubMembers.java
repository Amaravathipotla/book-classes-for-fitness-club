
package ClubForFitness;

import java.util.ArrayList;
import java.util.List;


public class ClubMembers {
    
    private String member_code;
    private String member_name;
    private String member_registered_on;
    
    
    public static ArrayList <ClubMembers> club_members = new ArrayList<>();

    public ClubMembers(String member_code, String member_name, String member_registered_on) {
        this.member_code = member_code;
        this.member_name = member_name;
        this.member_registered_on = member_registered_on;
    }

    public String getMember_code() {
        return member_code;
    }

    public String getMember_name() {
        return member_name;
    }


    public String getMember_registered_on() {
        return member_registered_on;
    }

    public static ArrayList<ClubMembers> getClub_members() {
        return club_members;
    }
   
         
    public static  List<ClubMembers> club_members(){
        return club_members;
    }
    
//    public static void pre_registered_members(){
//        ClubMembers cm1 = new ClubMembers("MCode1705","Beth Knight","024 7652 1200","01Jan,2023");
//        ClubMembers cm2 = new ClubMembers("MCode2840","Kirsten Graham","01902 773608","14Jan,2023");
//        ClubMembers cm3 = new ClubMembers("MCode1705","Natalie Saunders","01437 767070","18Jan,2023");
//        ClubMembers cm4 = new ClubMembers("MCode1705","Duncan Patel","01493 331901","24Jan,2023");
//        ClubMembers cm5 = new ClubMembers("MCode1705","Kelly Simpson","01483 770742","29Jan,2023");
//        ClubMembers cm6 = new ClubMembers("MCode1705","Joanne Reynolds","01293 785363","17Jan,2023");
//        ClubMembers cm7 = new ClubMembers("MCode1705","Layla Hill","01392 366990","05Jan,2023");
//        ClubMembers cm8 = new ClubMembers("MCode1705","Candice Scott","01398 324130","09Jan,2023");
//        ClubMembers cm9 = new ClubMembers("MCode1705","Alexander Cook","0113 234 6820","10Jan,2023");
//        ClubMembers cm10 = new ClubMembers("MCode1705","Sabrina Cooper","01233 750269","16Jan,2023");
//        
//        ClubMembers.club_members.add(cm1);
//        ClubMembers.club_members.add(cm2);
//        ClubMembers.club_members.add(cm3);
//        ClubMembers.club_members.add(cm4);
//        ClubMembers.club_members.add(cm5);
//        ClubMembers.club_members.add(cm6);
//        ClubMembers.club_members.add(cm7);
//        ClubMembers.club_members.add(cm8);
//        ClubMembers.club_members.add(cm9);
//        ClubMembers.club_members.add(cm10);
//    }
}
