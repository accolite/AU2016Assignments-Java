package MarshallAndUnmarshall;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println(" press 1  marshall press 2 for unmarshall ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		int i = 0;
		while (i != 2) {
			switch (choice) {
			case 1:
				Marshal marshal = new Marshal();
				marshal.marshalling();
				break;
			case 2:
				Unmarshall unmarshall = new Unmarshall();
				unmarshall.unmarshalling();
			default:
				break;
			}
			i++;
			if (i != 2) {
				System.out.println(" press 1  marshall press 2 for unmarshall ");

				choice = sc.nextInt();
			}
		}
	}
}