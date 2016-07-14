package assignment.accolite.structure;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class States {
    private int stateID;
    private String stateName;
    private String status;

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStateID() {
        return stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStatus() {
        return status;
    }
}
