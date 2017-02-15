package com.clock.berlin;

import static org.junit.Assert.*;

import org.junit.Test;

public class BerlinClockLightTest {

	@Test
	public void tesColourst() {
		assertEquals('O', BerlinClockLight.OFF.getColourLetter());
		assertEquals('Y', BerlinClockLight.YELLOW.getColourLetter());
		assertEquals('R', BerlinClockLight.RED.getColourLetter());
	}

}
