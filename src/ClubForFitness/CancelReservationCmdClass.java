
package ClubForFitness;

import java.util.List;



public class CancelReservationCmdClass implements Command {

    private String reservationCode;

    public CancelReservationCmdClass(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    @Override
    public void executeFunction() {
        boolean isReservationCodeExists = UserInterface.isReservationCodeExists(reservationCode);
        if (!isReservationCodeExists) {
            System.out.println("\nReservation Code entered by you is not valid");
            return;
        }

        List<ClubReservations> club_reservations = ClubReservations.club_reservations();
        String day = "";
        String lesson = "";
        String time = "";
        String memberName = "";
        List<ClubLessons> club_lesson = ClubLessons.club_lessons();
        List<ClubMembers> club_members = ClubMembers.club_members();

        for (int i = 0; i < club_reservations.size(); i++) {
            if (club_reservations.get(i).getReservationCode().equalsIgnoreCase(reservationCode)) {
                club_reservations.get(i).setReservation_status(ClubReservations.CANCEL);
                for (int j = 0; j < club_lesson.size(); j++) {
                    if (club_lesson.get(j).getFitness_lesson().equalsIgnoreCase(club_reservations.get(i).getLesson())) {
                        day = club_lesson.get(i).getDay();
                        time = club_lesson.get(i).getTime();
                        lesson = club_lesson.get(i).getFitness_lesson();
                        club_lesson.get(i).setSeats_available(club_lesson.get(i).getSeats_available());
                    }
                }

                for (int j = 0; j < club_members.size(); j++) {
                    if (club_members.get(j).getMember_code().equalsIgnoreCase(club_reservations.get(i).getReserved_by())) {
                        memberName = club_members.get(j).getMember_name();
                    }
                }
            }
        }

        System.out.println("\n=====================================================================================================");
        System.out.println("Success Message :");
        System.out.println("Successfully Cancelled Lesson '" + lesson + "' on " + day + " at " + time + " for member '" + memberName + "'");
        System.out.println("=====================================================================================================");
    }
}