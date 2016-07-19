/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
public class Birthday {
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public Birthday(){
    }

    public Birthday(int date,int month,int year){
        this.birthDay = date;
        this.birthMonth = month;
        this.birthYear = year;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
