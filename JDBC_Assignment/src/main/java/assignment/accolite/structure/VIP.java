package assignment.accolite.structure;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class VIP {
    private int personID;
    private int relativeID;
    private String relation;

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setRelativeID(int relativeID) {
        this.relativeID = relativeID;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getPersonID() {
        return personID;
    }

    public int getRelativeID() {
        return relativeID;
    }

    public String getRelation() {
        return relation;
    }
}
