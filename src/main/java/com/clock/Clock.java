package com.clock;

public abstract class Clock {

	protected String hours;
	protected String minutes;
	protected String seconds;
	
	public Clock(Integer hours, Integer minutes, Integer seconds) throws ClockInitException{
    	if( !isValidTime(hours, minutes, seconds)) {
    		throw new ClockInitException("Invalid Time Input");
		}
	}

	private boolean isValidTime(Integer hours, Integer minutes, Integer seconds) {
		boolean valid = true;
		if(hours>23 || minutes>59 || seconds>59)
			valid = false;
		return valid;
	}

	public String getHours() {
		return hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public String getSeconds() {
		return seconds;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime * result + ((minutes == null) ? 0 : minutes.hashCode());
		result = prime * result + ((seconds == null) ? 0 : seconds.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clock other = (Clock) obj;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours))
			return false;
		if (minutes == null) {
			if (other.minutes != null)
				return false;
		} else if (!minutes.equals(other.minutes))
			return false;
		if (seconds == null) {
			if (other.seconds != null)
				return false;
		} else if (!seconds.equals(other.seconds))
			return false;
		return true;
	}
}
