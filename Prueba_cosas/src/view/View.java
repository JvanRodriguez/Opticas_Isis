package view;

import java.util.Scanner;

public class View {

	public void ShowMessage(String message) {
		System.out.println(message);
	}
	
	public String inputString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public double inputDouble() {
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}
	
	public int inputInteger() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
