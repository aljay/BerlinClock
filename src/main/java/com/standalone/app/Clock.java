package com.standalone.app;

import com.clock.ClockInitException;
import com.clock.berlin.BerlinClock;

public class Clock {

	public static void main(String[] args) {
		BerlinClock clock;
		if(args.length ==3) {
			try {
				clock = new BerlinClock(Integer.valueOf(args[0]), Integer.valueOf(args[1]), Integer.valueOf(args[2]));
				System.out.println(clock.getTime());
				return;
			} catch (NumberFormatException e) {
				System.out.println("Invalid time Input");
			} catch (ClockInitException e) {
				System.out.println(e.getMessage());
			}
		} 
		printInstructions();
	}
	
	private static void printInstructions() {
		System.out.println("Usage:");
		System.out.println("Enter hours minutes seconds in 24 hour format e.g.");
		System.out.println("23 59 58");
	}

}
