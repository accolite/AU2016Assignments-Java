package assignment.accolite.structure;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class District {
    private int districtID;
    private String districtName;
    private int stateID;
    private String status;
    private int headID;

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeadID(int headID) {
        this.headID = headID;
    }

    public int getDistrictID() {
        return districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public int getStateID() {
        return stateID;
    }

    public String getStatus() {
        return status;
    }

    public int getHeadID() {
        return headID;
    }
}
