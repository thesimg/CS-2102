package Lecture13Starter;

import java.util.List;

public interface ClubManagable {

    void intake(List<String> data);

    String mostPopular();

    int uniqueClubs();

    List<String> sortedEmails(String clubName);
}
