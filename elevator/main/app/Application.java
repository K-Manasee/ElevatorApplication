package elevator.main.app;

import java.util.Scanner;

public class Application {
	public static RequestQueue requestQueue;

	public static void main(String[] args) {
		System.out.println(
				"Enter input in form : FloorNumber,DIRECTION(UP/DOWN) \n And enter q to stop/exit the elevator app");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Elevator elevator = new Elevator();

		while (!input.equalsIgnoreCase("q")) {
			processRequest(input);
			System.out.println("Request is being served.. Starting elevator");
			elevator.init(requestQueue);
			elevator.operate();
			System.out.println(elevator.position);
		}
		sc.close();
	}

	public static void processRequest(String input) {
		String[] inputArray = input.split(",");
		UserInput userInput = new UserInput(Integer.parseInt(inputArray[0]), Direction.valueOf(inputArray[1]));
		requestQueue = new RequestQueue();
		requestQueue.add(userInput);
		// Check if any error/exception occured during procesing
	}

}
