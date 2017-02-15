package com.clock.berlin;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.clock.Clock;
import com.clock.ClockInitException;

public class BerlinClockTest {
	private final String clockFormat = "%s%n%s";
	private final String fullClockFormat = "%s%n%s%n%s%n%s%n%s";
	private final String smallPlaceHolder = "OOOO";
	private final String largePlaceHolder = "OOOOOOOOOOO";
	@Test
	public void testLargeHourIntervals() throws ClockInitException {
		Map<Integer, String> hourIntervals = new HashMap<Integer, String>();
		hourIntervals.put( 0, String.format(clockFormat, "OOOO", smallPlaceHolder));
		hourIntervals.put( 5, String.format(clockFormat, "ROOO", smallPlaceHolder));
		hourIntervals.put(10, String.format(clockFormat, "RROO", smallPlaceHolder));
		hourIntervals.put(15, String.format(clockFormat, "RRRO", smallPlaceHolder));
		hourIntervals.put(20, String.format(clockFormat, "RRRR", smallPlaceHolder));
		assertEquals( hourIntervals.get(0), new BerlinClock(0, 0, 0).getHours() );
		assertEquals( hourIntervals.get(5), new BerlinClock(5, 0, 0).getHours() );
		assertEquals( hourIntervals.get(10), new BerlinClock(10, 0, 0).getHours() );
		assertEquals( hourIntervals.get(15), new BerlinClock(15, 0, 0).getHours() );
		assertEquals( hourIntervals.get(20), new BerlinClock(20, 0, 0).getHours() );
	}
	
	@Test
	public void testSmallHourIntervals() throws ClockInitException {
		Map<Integer, String> hourIntervals = new HashMap<Integer, String>();
		hourIntervals.put(0, String.format(clockFormat, smallPlaceHolder, "OOOO"));
		hourIntervals.put(1, String.format(clockFormat, smallPlaceHolder, "ROOO"));
		hourIntervals.put(2, String.format(clockFormat, smallPlaceHolder, "RROO"));
		hourIntervals.put(3, String.format(clockFormat, smallPlaceHolder, "RRRO"));
		hourIntervals.put(4, String.format(clockFormat, smallPlaceHolder, "RRRR"));
		assertEquals( hourIntervals.get(0), new BerlinClock(0, 0, 0).getHours() );
		assertEquals( hourIntervals.get(1), new BerlinClock(1, 0, 0).getHours() );
		assertEquals( hourIntervals.get(2), new BerlinClock(2, 0, 0).getHours() );
		assertEquals( hourIntervals.get(3), new BerlinClock(3, 0, 0).getHours() );
		assertEquals( hourIntervals.get(4), new BerlinClock(4, 0, 0).getHours() );
	}
	
	@Test
	public void testLargeMinuteIntervals() throws ClockInitException {
		Map<Integer, String> minuteIntervals = new HashMap<Integer, String>();
		minuteIntervals.put( 0, String.format(clockFormat, "OOOOOOOOOOO", smallPlaceHolder));
		minuteIntervals.put( 5, String.format(clockFormat, "YOOOOOOOOOO", smallPlaceHolder));
		minuteIntervals.put(10, String.format(clockFormat, "YYOOOOOOOOO", smallPlaceHolder));
		minuteIntervals.put(15, String.format(clockFormat, "YYROOOOOOOO", smallPlaceHolder));
		minuteIntervals.put(20, String.format(clockFormat, "YYRYOOOOOOO", smallPlaceHolder));
		minuteIntervals.put(25, String.format(clockFormat, "YYRYYOOOOOO", smallPlaceHolder));
		minuteIntervals.put(30, String.format(clockFormat, "YYRYYROOOOO", smallPlaceHolder));
		minuteIntervals.put(35, String.format(clockFormat, "YYRYYRYOOOO", smallPlaceHolder));
		minuteIntervals.put(40, String.format(clockFormat, "YYRYYRYYOOO", smallPlaceHolder));
		minuteIntervals.put(45, String.format(clockFormat, "YYRYYRYYROO", smallPlaceHolder));
		minuteIntervals.put(50, String.format(clockFormat, "YYRYYRYYRYO", smallPlaceHolder));
		minuteIntervals.put(55, String.format(clockFormat, "YYRYYRYYRYY", smallPlaceHolder));
		assertEquals( minuteIntervals.get(0), new BerlinClock(0, 0, 0).getMinutes() );
		assertEquals( minuteIntervals.get(5), new BerlinClock(0, 5, 0).getMinutes() );
		assertEquals( minuteIntervals.get(10), new BerlinClock(0, 10, 0).getMinutes() );
		assertEquals( minuteIntervals.get(15), new BerlinClock(0, 15, 0).getMinutes() );
		assertEquals( minuteIntervals.get(20), new BerlinClock(0, 20, 0).getMinutes() );
		assertEquals( minuteIntervals.get(25), new BerlinClock(0, 25, 0).getMinutes() );
		assertEquals( minuteIntervals.get(30), new BerlinClock(0, 30, 0).getMinutes() );
		assertEquals( minuteIntervals.get(35), new BerlinClock(0, 35, 0).getMinutes() );
		assertEquals( minuteIntervals.get(40), new BerlinClock(0, 40, 0).getMinutes() );
		assertEquals( minuteIntervals.get(45), new BerlinClock(0, 45, 0).getMinutes() );
		assertEquals( minuteIntervals.get(50), new BerlinClock(0, 50, 0).getMinutes() );
		assertEquals( minuteIntervals.get(55), new BerlinClock(0, 55, 0).getMinutes() );
	}
	
	@Test
	public void testSmallMinuteIntervals() throws ClockInitException {
		Map<Integer, String> minuteIntervals = new HashMap<Integer, String>();
		minuteIntervals.put(0, String.format(clockFormat, largePlaceHolder, "OOOO"));
		minuteIntervals.put(1, String.format(clockFormat, largePlaceHolder, "YOOO"));
		minuteIntervals.put(2, String.format(clockFormat, largePlaceHolder, "YYOO"));
		minuteIntervals.put(3, String.format(clockFormat, largePlaceHolder, "YYYO"));
		minuteIntervals.put(4, String.format(clockFormat, largePlaceHolder, "YYYY"));
		assertEquals( minuteIntervals.get(0), new BerlinClock(0, 0, 0).getMinutes() );
		assertEquals( minuteIntervals.get(1), new BerlinClock(0, 1, 0).getMinutes() );
		assertEquals( minuteIntervals.get(2), new BerlinClock(0, 2, 0).getMinutes() );
		assertEquals( minuteIntervals.get(3), new BerlinClock(0, 3, 0).getMinutes() );
		assertEquals( minuteIntervals.get(4), new BerlinClock(0, 4, 0).getMinutes() );
	}

	@Test
	public void testSecondIntervals() throws ClockInitException {
		assertEquals( "Y", new BerlinClock(0, 0, 0).getSeconds() );
		assertEquals( "O", new BerlinClock(0, 0, 1).getSeconds() );
		assertEquals( "Y", new BerlinClock(0, 0, 2).getSeconds() );
		assertEquals( "O", new BerlinClock(0, 0, 59).getSeconds() );
	}
	
	@Test(expected=ClockInitException.class)
	public void testInvalidHoursFails() throws ClockInitException {
		new BerlinClock(24, 0, 0);
	}
	
	@Test(expected=ClockInitException.class)
	public void testInvalidMinutesFails() throws ClockInitException {
		new BerlinClock(0, 60, 0);
	}
	
	@Test(expected=ClockInitException.class)
	public void testInvalidSecondsFails() throws ClockInitException {
		new BerlinClock(0, 0, 60);
	}
	
	@Test
	public void testMidnightNoLights() throws ClockInitException{
		
		String expected = String.format(fullClockFormat, 
				"O", 
				"OOOO", 
				"OOOO", 
				"OOOOOOOOOOO",
				"OOOO");
		assertEquals( expected, new BerlinClock(0, 0, 1).getTime() );
	}
	
	@Test
	public void testPreMidNightMaxLights() throws ClockInitException{
		String expected = String.format(fullClockFormat, 
				"Y", 
				"RRRR", 
				"RRRO", 
				"YYRYYRYYRYY",
				"YYYY");
		assertEquals( expected, new BerlinClock(23, 59, 58).getTime() );
	}
	
	@Test
	public void testEquality() throws ClockInitException{
		BerlinClock expected = new BerlinClock(23, 23, 23);
		BerlinClock copy = new BerlinClock(23, 23, 23);
		assertEquals( expected, copy);
		assertEquals(expected, expected);
		assertEquals(expected.hashCode(), copy.hashCode());
		
		assertNotEquals(expected, null);
		assertNotEquals(expected, new BerlinClock(22, 23, 23));
		assertNotEquals(expected, new BerlinClock(23, 22, 23));
		assertNotEquals(expected, new BerlinClock(23, 23, 22));
		assertNotEquals(expected, new String("porcupine"));
		assertNotEquals(expected, new BerlinClock(23, 22, 23));
		
		Class<Clock> clock = Clock.class;
		Clock testClock = new BerlinClock( 23, 23, 23 );
		
		try {
			Field hours = clock.getDeclaredField("hours");
			hours.setAccessible(true);
			Field minutes = clock.getDeclaredField("minutes");
			minutes.setAccessible(true);
			Field seconds = clock.getDeclaredField("seconds");
			seconds.setAccessible(true);

			seconds.set(testClock, null);
			assertFalse(expected.equals(testClock));
			assertFalse(testClock.equals(expected));

			minutes.set(testClock, null);
			assertFalse(expected.equals(testClock));
			assertFalse(testClock.equals(expected));
			
			hours.set(testClock, null);
			assertFalse(expected.equals(testClock));
			assertFalse(testClock.equals(expected));
	
			assertEquals(testClock.hashCode(), 29791);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	
}
