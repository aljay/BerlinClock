package com.clock.berlin;

public enum BerlinClockLight {
	 
	YELLOW('Y'), RED('R'), OFF('O');
 
	private char colourLetter;
 
	private BerlinClockLight(char letter) {
		colourLetter = letter;
	}
 
	public char getColourLetter() {
		return colourLetter;
	}
}