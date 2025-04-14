package Lecture13Starter;

import java.util.LinkedList;
import java.util.List;

public class CSClubRostersRTP extends ClubRostersRTP {
    private List<String> csClubRosters;

    public CSClubRostersRTP(List<String> data, List<String> csClubNames) {
        super(data);
        this.csClubRosters = csClubNames;
    }

    @Override
    public void clean() {
        super.clean();

        List<String> cleanedData = new LinkedList<String>();

        for (int i = 0; i < this.data.size(); i++) {
            String studentEmail = this.data.get(i);
            String clubName = this.data.get(i+1);
            if(! this.csClubRosters.contains(clubName)) {
                cleanedData.add(studentEmail);
                cleanedData.add(clubName);
            }
        }
        this.data = cleanedData;
    }


}
