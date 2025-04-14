package Lecture13Starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClubRostersRTP extends ClubRostersTemplate implements ClubManagable {

    public ClubRostersRTP(List<String> data) {
        this.intake(data);
    }


    @Override
    protected void postIntake() {
        this.clean();
        this.parse();
    }

    @Override
    protected void preQuery() {

    }
}
