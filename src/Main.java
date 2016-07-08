import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static MyLinkedHashMap myLinkedHashMap = new MyLinkedHashMap();

    public static void getFromKey(int key){
        HashMap hashMap = myLinkedHashMap.getMyHashMap();
        System.out.println("value : " + hashMap.get(key));
    }

    public static void getFromInsertionOrder(int key){
        try {
            HashMap hashMap = myLinkedHashMap.getMyHashMap();
            ArrayList<Node> orderOfInsertion = myLinkedHashMap.getNodeArrayList();
            System.out.println("key: " + orderOfInsertion.get(key).getKey() + " value : " + hashMap.get(orderOfInsertion.get(key).getKey()));
        }catch(Exception e){
            System.out.println("No such index exists");
        }
    }


    public static void inputValue(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter key : ");
        int key = input.nextInt();
        System.out.println("Enter value : ");
        int value = input.nextInt();
        myLinkedHashMap.put(key,value);
    }

    public static void displayHashMap(){
        HashMap hashMap = myLinkedHashMap.getMyHashMap();
        System.out.println("Values as per hash map");
        for (Object key : hashMap.keySet()) {
            System.out.println("key: " + key + " value: " + hashMap.get(key));
        }
    }

    public static void displayInsertionOrder(){
        HashMap hashMap = myLinkedHashMap.getMyHashMap();
        System.out.println("Values as per insertion order");
        ArrayList<Node> orderOfInsertion = myLinkedHashMap.getNodeArrayList();
        for(int i =0;i<orderOfInsertion.size();i++){
            System.out.println("key: " + orderOfInsertion.get(i).getKey() + " value : " + hashMap.get(orderOfInsertion.get(i).getKey()));

        }
    }

    public static int input(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void menu(){
        int choice;
        char cont = 'y';
        while(cont == 'y'){
            System.out.print("1. input value \n2. Display value as per hash map \n3. Display value as per insertion order \n4. display from key\n5. display from insertion order");
            System.out.println("\n\nInput choice");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch(choice){
                case 1: inputValue(); break;
                case 2 : displayHashMap(); break;
                case 3 : displayInsertionOrder(); break;
                case 4 : getFromKey(input()); break;
                case 5 : getFromInsertionOrder(input());break;
                default : System.exit(0);
            }
            System.out.println("continue...");
            cont = input.next().charAt(0);
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        menu();
/*
        myLinkedHashMap.put("1",1234);
        myLinkedHashMap.put("3",12);
        myLinkedHashMap.put("2",5678);
        myLinkedHashMap.put(null,5678);
        myLinkedHashMap.put(null,1234);
        System.out.println("value with key : 1 " + myLinkedHashMap.get("1"));
        System.out.println("value with key : 2 " + myLinkedHashMap.get("2"));

        ///
        HashMap hashMap = myLinkedHashMap.getMyHashMap();
        System.out.println("Values as per hash map");
        for (Object key : hashMap.keySet()) {
            System.out.println("key: " + key + " value: " + hashMap.get(key));
        }

        System.out.println("Values as per insertion order");
        ArrayList<Node> orderOfInsertion = myLinkedHashMap.getNodeArrayList();
        for(int i =0;i<orderOfInsertion.size();i++){
            System.out.println("key: " + orderOfInsertion.get(i).getKey() + " value : " + hashMap.get(orderOfInsertion.get(i).getKey()));

        }

*/
    }
}
