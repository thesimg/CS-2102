package Lecture13Starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClubRostersBP implements ClubManagable {

    public List<String> intakeData;
    public List<ClubRoster> sortedRosters;

    public ClubRostersBP(){
        this.intakeData = new ArrayList<>();
        this.sortedRosters = new LinkedList<>();
    }

    public void intake(List<String> data){
        this.intakeData.addAll(data);
    }

    public void clean(){
        List<String> cleanedData = new ArrayList<>();
        for(int i = 0; i < this.intakeData.size(); i+=2){
            if(this.intakeData.get(i).endsWith("@wpi.edu")){
                cleanedData.add(this.intakeData.get(i));
                cleanedData.add(this.intakeData.get(i+1));
            }
        }
        this.intakeData = cleanedData;
    }

    public void parse(){
        for(int i = 0; i < this.intakeData.size(); i+=2){
            ClubRoster roster = this.findOrCreate(this.intakeData.get(i+1));
            roster.addEmail(this.intakeData.get(i));
        }
        this.intakeData.clear();
    }

    public void sort(){
        for(ClubRoster roster : this.sortedRosters){
            roster.sort();
        }
    }

    private ClubRoster findOrCreate(String clubName){
        for(ClubRoster roster : this.sortedRosters){
            if(roster.getClubName().equals(clubName)){
                return roster;
            }
        }
        ClubRoster roster = new ClubRoster(clubName);
        this.sortedRosters.add(roster);
        return roster;
    }

    public String mostPopular(){
        this.clean();
        this.parse();
        this.sort();

        if(this.sortedRosters.isEmpty()){
            return "N/A";
        }
        ClubRoster mostPopularSoFar = this.sortedRosters.get(0);
        for(ClubRoster roster : this.sortedRosters){
            if(roster.size() > mostPopularSoFar.size()){
                mostPopularSoFar = roster;
            }
        }
        return mostPopularSoFar.getClubName();

    }

    public int uniqueClubs(){
        this.clean();
        this.parse();
        this.sort();
        return this.sortedRosters.size();
    }

    public List<String> sortedEmails(String clubName){
        this.clean();
        this.parse();
        this.sort();
        for(ClubRoster roster : this.sortedRosters){
            if(roster.getClubName().equals(clubName)){
                return roster.getEmails();
            }
        }
        return List.of();
    }
}
