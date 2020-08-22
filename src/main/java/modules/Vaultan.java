package modules;

import coremodules.User;

public class Vaultan extends User {
    protected int earnedStanding;
    protected int permanentStanding;

    public int getEarnedStanding() {
        return earnedStanding;
    }

    public int getPermanentStanding() {
        return permanentStanding;
    }

    public void setEarnedStanding(int earnedStanding) {
        this.earnedStanding = earnedStanding;
    }

    public void setPermanentStanding(int permanentStanding) {
        this.permanentStanding = permanentStanding;
    }

    public void addEarnedStanding(int earnedStanding){
        this.earnedStanding+=earnedStanding;
    }

    public void addPermanentStanding(int permanentStanding){
        this.permanentStanding+=permanentStanding;
    }

}
