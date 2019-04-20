package elevator.main.app;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Elevator {
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public RequestQueue getRequestQueue() {
		return requestQueue;
	}

	public void setRequestQueue(RequestQueue requestQueue) {
		this.requestQueue = requestQueue;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public TreeSet<Integer> getDestinations() {
		return destinations;
	}

	public void setDestinations(TreeSet<Integer> destinations) {
		this.destinations = destinations;
	}

	public int position;
	public RequestQueue requestQueue;
	public Direction direction;
	TreeSet<Integer> destinations;
	
	public void incrementPosition() {
		System.out.println("Moving from position "+ position);
		 position++;
		 System.out.println("Current position is : "+position);
	 }

	public void decrementPosition() {
		System.out.println("Moving from position "+ position);
		 position--;
		 System.out.println("Current position is : "+position);
	 }

	public Elevator() {
		this.position=0;
	}

	public Elevator init(RequestQueue requestQueue) {
		this.direction = requestQueue.peek().direction;
		this.requestQueue = requestQueue;
		return this;
	}

	public void operate(){
		
		checkRequestQueue();
	}
	private void moveElevator() {
		// TODO Auto-generated method stub
		
	}

	private void checkRequestQueue() {
		while(this.position!=requestQueue.peek().floor)
			incrementPosition();
		openAndSetDestinationOfElevator();
	}

	private void openAndSetDestinationOfElevator() {
		System.out.println("Enter destinations...integer format and new line seperated");
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> destinations = new TreeSet<>();
		int d = sc.nextInt();
		while(d!=-1) {
			destinations.add(d);
			d=sc.nextInt();
		}
		setDestinations(requestQueue.peek().direction==Direction.UP ? destinations: (TreeSet<Integer>) destinations.descendingSet());
		if(destinations.first()>position)
			incrementPosition();
		else 
			decrementPosition();
		
	}
}
