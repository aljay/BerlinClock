package com.clock.berlin;

import com.clock.Clock;
import com.clock.ClockInitException;

public class BerlinClock extends Clock {

	private final String clockFormat = "%s%n%s";
	private final String smallPlaceHolder = "OOOO";
	private final String largePlaceHolder = "OOOOOOOOOOO";
	private final int regularInterval = 5;
	private final int quarterInterval = 3;
	
	public BerlinClock(Integer hours, Integer minutes, Integer seconds) throws ClockInitException{
		super(hours, minutes, seconds);
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	public String getTime() {
		return String.format("%s%n%s%n%s", seconds, hours, minutes);
	}

	private void setHours(Integer hours) {
		int largeHourIntervals = Math.abs(hours/regularInterval);
		String topRow = translateSmallRow(largeHourIntervals, BerlinClockLight.RED);
		
		int smallHourIntervals = Math.floorMod(hours, regularInterval);
		String bottomRow = translateSmallRow(smallHourIntervals, BerlinClockLight.RED);
		
		this.hours = String.format(clockFormat, new String(topRow), new String(bottomRow));
	}

	private String translateSmallRow(int smallRowIntervals, BerlinClockLight light) {
		char[] smallRow = smallPlaceHolder.toCharArray();
		for(int i = 0; i<smallRowIntervals; i++){
			smallRow[i] = light.getColourLetter();
		}
		return new String(smallRow);
	}
	
	private void setMinutes(Integer minutes) {
		int largeMinuteIntervals = Math.abs(minutes/regularInterval);
		String topRow = translateLargeRow(largeMinuteIntervals, BerlinClockLight.RED, BerlinClockLight.YELLOW);
		
		int smallMinuteIntervals = Math.floorMod(minutes, regularInterval);
		String bottomRow = translateSmallRow(smallMinuteIntervals, BerlinClockLight.YELLOW);
		
		this.minutes = String.format(clockFormat, topRow, bottomRow);
	}

	private String translateLargeRow(int largeMinuteIntervals, BerlinClockLight primaryLight, BerlinClockLight secondaryLight) {
		char[] topRow = largePlaceHolder.toCharArray();
		for(int i = 1; i<=largeMinuteIntervals; i++){
			topRow[i-1] = Math.floorMod(i, quarterInterval) == 0? primaryLight.getColourLetter(): secondaryLight.getColourLetter();
		}
		return new String(topRow);
	}

	private void setSeconds(Integer seconds) {
		char status = (seconds & 1) == 0? BerlinClockLight.YELLOW.getColourLetter(): BerlinClockLight.OFF.getColourLetter();
		this.seconds = String.valueOf(status);
	}

}
