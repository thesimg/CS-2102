package Lecture13Starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class ClubRostersTemplate implements ClubManagable {

    public List<String> intakeData;
    public List<ClubRoster> rosters;

    public ClubRostersTemplate(){
        this.intakeData = new ArrayList<>();
        this.rosters = new LinkedList<>();
    }

    protected abstract void postIntake();
    protected abstract void preQuery();

    public void intake(List<String> data){
        this.intakeData.addAll(data);
        this.postIntake(); // sub-class responsibility
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
        for(ClubRoster roster : this.rosters){
            roster.sort();
        }
    }

    private ClubRoster findOrCreate(String clubName){
        for(ClubRoster roster : this.rosters){
            if(roster.getClubName().equals(clubName)){
                return roster;
            }
        }
        ClubRoster roster = new ClubRoster(clubName);
        this.rosters.add(roster);
        return roster;
    }

    public String mostPopular(){
        this.preQuery();
//        this.clean();
//        this.parse();
//        this.sort();

        if(this.rosters.isEmpty()){
            return "N/A";
        }
        ClubRoster mostPopularSoFar = this.rosters.get(0);
        for(ClubRoster roster : this.rosters){
            if(roster.size() > mostPopularSoFar.size()){
                mostPopularSoFar = roster;
            }
        }
        return mostPopularSoFar.getClubName();

    }

    public int uniqueClubs(){
        this.preQuery();
        return this.rosters.size();
    }

    public List<String> sortedEmails(String clubName){
        this.preQuery();
//        this.clean();
//        this.parse();
//        this.sort();
        for(ClubRoster roster : this.rosters){
            if(roster.getClubName().equals(clubName)){
                return roster.getEmails();
            }
        }
        return List.of();
    }
}
