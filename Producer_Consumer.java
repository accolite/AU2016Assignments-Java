import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Mitul Kapoor on 7/18/2016.
 */
public class LockService {

        static final int MAX_FRUITS = 5;

        public enum Fruit {
            apple, grape, watermelon, orange
        }

        public static BlockingQueue<Fruit> appleQueue = new ArrayBlockingQueue<Fruit>(MAX_FRUITS);
        public static BlockingQueue<Fruit> orangeQueue = new ArrayBlockingQueue<Fruit>(MAX_FRUITS );
        public static BlockingQueue<Fruit> grapeQueue = new ArrayBlockingQueue<Fruit>(MAX_FRUITS );
        public static BlockingQueue<Fruit> watermelonQueue = new ArrayBlockingQueue<Fruit>(MAX_FRUITS );


        public static class Producer {
            public void add(Fruit fruit) throws InterruptedException {
                switch (fruit) {
                    case orange:
                        if(orangeQueue.size() < MAX_FRUITS ) {
                            System.out.println("Added Orange to market");
                            orangeQueue.add(fruit);
                        }else{
                            System.out.println("Cannot add");
                        }
                        break;
                    case apple:
                        if(appleQueue.size() < MAX_FRUITS ) {
                            System.out.println("Added Apple to market");
                            appleQueue.add(fruit);
                        }else{
                            System.out.println("Cannot add");
                        }
                        break;
                    case grape:
                        if(grapeQueue.size() < MAX_FRUITS ) {
                            System.out.println("Added Grape to market");
                            grapeQueue.add(fruit);
                        }else{
                            System.out.println("Cannot add");
                        }
                        break;
                    case watermelon:
                        if(watermelonQueue.size() < MAX_FRUITS ) {
                            System.out.println("Added Watermelon to market");
                            watermelonQueue.add(fruit);
                        }else{
                            System.out.println("Cannot add");
                        }
                        break;
                }
            }
        }

        public static class Consumer extends Thread {
            Fruit fruit;

            public Consumer(Fruit f) {
                fruit = f;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        switch (fruit) {
                            case orange:
                                System.out.println("Customer taking : " + orangeQueue.take());
                                break;
                            case apple:
                                System.out.println("Customer taking : " + appleQueue.take());
                                break;
                            case grape:
                                System.out.println("Customer taking : " + grapeQueue.take());
                                break;
                            case watermelon:
                                System.out.println("Customer taking : " + watermelonQueue.take());
                                break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            Producer producer = new Producer();
            int cont = 1;
            while(cont==1) {
                System.out.println("1. Farmer");
                System.out.println("2. Customer");
                System.out.println("3. Show status");
                System.out.println("Enter role : ");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();

                switch(choice){
                    case 1 : producer.add(getFruit()); break;
                    case 2 : new Consumer(getFruit()).start();break;
                    case 3 : showAllFruits();break;
                    default : System.out.println("Wrong choice! \n");
                }
                System.out.println("continue(0/1)....");
                cont = input.nextInt();
            }

        }

    private static void showAllFruits() {
        System.out.println("Apple : " + appleQueue.size());
        System.out.println("Orange : " + orangeQueue.size());
        System.out.println("Grape : " + grapeQueue.size());
        System.out.println("Watermelon : " + watermelonQueue.size());
    }

    public static Fruit getFruit(){
            System.out.println("1. Apple");
            System.out.println("2. Orange");
            System.out.println("3. Grape");
            System.out.println("4. Watermelon");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch(choice){
                case 1 : return Fruit.apple;
                case 2 : return Fruit.orange;
                case 3: return Fruit.grape;
                case 4: return Fruit.watermelon;
                default:break;
            }
            return null;
        }
    }
