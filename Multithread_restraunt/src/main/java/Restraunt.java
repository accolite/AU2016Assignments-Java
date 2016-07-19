import java.util.Scanner;

/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
public class Restraunt {

    private static float totalBillAmount = 0;
    private static int totalNumberOfBills = 0;

    public synchronized static void setTotalBillAmount(float amount) {
        totalBillAmount = amount;
    }

    public synchronized static void setTotalNumberOfBills(int number) {
        totalNumberOfBills = number;
    }

    public synchronized static float getTotalBillAmount() {
        return totalBillAmount;
    }

    public synchronized static int getTotalNumberOfBills() {
        return totalNumberOfBills;
    }

    public static class ChangeInAverage implements Runnable{

        Float newAverage;
        Float prevAverage;

        public ChangeInAverage(Float prevA,Float newA){
            prevAverage = prevA;
            newAverage = newA;
        }

        public void setPrevAverage(Float prevAverage) {
            this.prevAverage = prevAverage;
        }

        public Float getPrevAverage() {
            return prevAverage;
        }

        public ChangeInAverage(){
            newAverage = Float.valueOf(0);
        }

        public Float getNewAverage() {
            return newAverage;
        }

        public void setNewAverage(Float newAverage) {
            this.newAverage = newAverage;
        }

        public void run() {
            if(this.getNewAverage().compareTo(getPrevAverage())!=0){
                System.out.println("---------------------");
                System.out.println("New Average : " + (getTotalBillAmount()/getTotalNumberOfBills()));
                System.out.println("---------------------");
            }
        }
    }

    public static class TableBill implements Runnable {

        private float tableBill = 0;

        public void setTableBill(float tableBill) {
            this.tableBill = tableBill;
        }

        public float getTableBill() {
            return tableBill;
        }

        public void run() {
            System.out.println("Enter bill for table : ");
            Scanner input = new Scanner(System.in);
            this.setTableBill(input.nextFloat());
            setTotalBillAmount(totalBillAmount + this.getTableBill());
            setTotalNumberOfBills(++totalNumberOfBills);
        }
    }

    public static void menu() throws InterruptedException {
        System.out.println("1. Query total bill");
        System.out.println("2. Pay Table bill");
        System.out.println("Enter choice .. ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice){
            case 1 :System.out.println("---------------------");
                System.out.println("Total Amount average : " + getTotalBillAmount()/getTotalNumberOfBills());
                System.out.println("---------------------");
                break;
            case 2 : Thread thread = new Thread(new TableBill());
                    Float previousAverage = getTotalBillAmount()/getTotalNumberOfBills();
                    thread.start();
                    thread.join();
                    Thread thread1 = new Thread(new ChangeInAverage(previousAverage,getTotalBillAmount()/getTotalNumberOfBills()));
                    thread1.start();
                    break;
            default : System.out.println("Wrong input!");
        }
    }

    public static void main(String [] args) throws InterruptedException {
        while(true){
            menu();
        }
    }
}
