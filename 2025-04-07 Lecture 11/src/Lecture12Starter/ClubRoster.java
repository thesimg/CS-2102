package Lecture12Starter;
import java.util.LinkedList;
import java.util.List;

public class ClubRoster {
    public String clubName;
    public List<String> emails;

    public ClubRoster(String clubName){
        this.clubName = clubName;
        this.emails = new LinkedList<>();
    }

    public void addEmail(String email){
        this.emails.add(email);
    }

    public void sort(){
        this.emails.sort(String::compareTo);
    }

    public List<String> getEmails(){
        return new LinkedList<>(this.emails);
    }

    public int size(){
        return this.emails.size();
    }

    public String getClubName(){
        return this.clubName;
    }
}
