package Lecture11Starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClubRosters implements ClubManagable {

    public List<String> data;

    public List<ClubRoster> rosters;

    public ClubRosters(List<String> data){
        this.data = data;
    }

    public void intake(List<String> data){
        this.data.addAll(data);
        this.clean();
        this.parse();
    }

    public void parse(){
        for(int i = 0; i < data.size(); i++){
            String email = data.get(i);
            String clubName = data.get(i+1);

            // hey, is this club in the rosters list?
            int index = rosters.indexOf(new ClubRoster(clubName));
            if (index == -1){
                ClubRoster roster = new ClubRoster(clubName);
                roster.addEmail(email);
                rosters.add(roster);
            } else {
                ClubRoster roster = rosters.get(index);
                roster.addEmail(email);
            }
            data.clear();

            for(ClubRoster roster : rosters){
                roster.emails.sort(String::compareTo);
            }

            rosters.sort(ClubRoster::compareTo);
        }
    }

    public void clean() {
        List<String> cleaned = new LinkedList<>();
        for (int i = 0; i < data.size(); i+=2) {
            if(data.get(i).contains("@wpi.edu")){
                cleaned.add(data.get(i));
                cleaned.add(data.get(i+1));
            }
        }
        this.data = cleaned;
    }

    public String mostPopular(){
        ClubRoster roster = new ClubRoster("N/A");
        for(ClubRoster r : this.rosters){
            if(r.size() > biggest.size()){
                size = r;
            }
        }

        int biggestCount = 0;
        String biggestClub = "N/A";
        for(int i = 0; i < clubs.size(); i++){
            if(counts.get(i) > biggestCount){
                biggestCount = counts.get(i);
                biggestClub = clubs.get(i);
            }
        }
        return biggestClub;

    }

    public int uniqueClubs(){
        return rosters.size();
    }

    public List<String> sortedEmails(String clubName){
        int index = rosters.indexOf(new ClubRoster(clubName));
        List<String> emails = rosters.get(index).getEmails();
        if(index != -1){
            rosters.get(index).getEmails();
        }

        return emails;
    }
}
