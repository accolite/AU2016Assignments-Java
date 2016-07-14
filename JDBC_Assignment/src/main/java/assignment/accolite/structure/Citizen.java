package assignment.accolite.structure;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class Citizen {
    private int personID;
    private String name;
    private int districtID;
    private int age;
    private String status;

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public int getDistrictID() {
        return districtID;
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }
}
