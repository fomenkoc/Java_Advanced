package com.gmail.fomenkoc.homeworks.homework24.enums;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum Days {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	public static Predicate<String> isCorrect = s -> contains(s);
	
	
	static boolean contains(String str) {
		List<Days> days = Arrays.asList(Days.values());
		for (Days day : days) {
			if (day.toString().equalsIgnoreCase(str))
				return true;
		}
		return false;
	}
	
	
}
