package com.gmail.fomenkoc.homeworks.homework24.classes;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Time {
	private int hours;
	private int minutes;
	private BiPredicate<Integer, Integer> isCorrectTime = (hh, mm) -> 
									hh >= 0 && hh < 24 && mm >= 0 && mm < 60;
									
    public Function<Time, Integer> timeToMinutes = t ->
    											t.hours * 60 + t.getMinutes();
    public static Function<Integer, Time> newByMin = i -> new Time(i/60, i%60);

	public Time(int hours, int minutes) {
		if (isCorrectTime.test(hours, minutes)) {
			this.hours = hours;
			this.minutes = minutes;
		} else {
			throw new IllegalArgumentException("[" + hours + ":" + minutes
					+ "] Incorrect time format (hours 0-23, minutes 0-59)");
		}

	}
	
	public Time calcNewTime(Time startTime, Time duration) {
		int hours;
		int minutes = timeToMinutes.apply(startTime);
		minutes += timeToMinutes.apply(duration);
		hours = minutes / 60;
		minutes = minutes % 60;
		
		while (hours >= 24)
			hours -= 24;
		
		return new Time(hours, minutes);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if (isCorrectTime.test(hours, 0)) {
			this.hours = hours;
		} else {
			throw new IllegalArgumentException("[" + hours + ":00"
					+ "] Incorrect time format (hours 0-23, minutes 0-59)");
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if (isCorrectTime.test(0, minutes)) {
			this.minutes = minutes;
		} else {
			throw new IllegalArgumentException("[00:" + minutes
					+ "] Incorrect time format (hours 0-23, minutes 0-59)");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(hours, minutes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hours == other.hours && minutes == other.minutes;
	}

	@Override
	public String toString() {
		if (this.hours > 9 && this.minutes > 9) {
			return hours + ":" + minutes;
		} else if (this.hours > 9 && this.minutes <= 9) {
			return hours + ":0" + minutes;
		} else if (this.hours <= 9 && this.minutes > 9) {
			return "0" + hours + ":" + minutes;
		} else {
			return "0" + hours + ":0" + minutes;
		}
	}

}
