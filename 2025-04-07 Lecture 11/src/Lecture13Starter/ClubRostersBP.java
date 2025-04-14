package Lecture13Starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClubRostersBP extends ClubRostersTemplate implements ClubManagable {
    public ClubRostersBP(List<String> data) {
        super();
        this.intake(data);
    }


    @Override
    protected void postIntake() {

    }

    @Override
    protected void preQuery() {
        this.clean();
        this.parse();
    }
}
