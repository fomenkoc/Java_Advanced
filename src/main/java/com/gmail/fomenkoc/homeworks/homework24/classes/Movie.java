package com.gmail.fomenkoc.homeworks.homework24.classes;

import java.util.Objects;

public class Movie {
	private String title;
	private Time duration;

	public Movie(String title, Time duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	
	public Movie(String title, int durationHours, int durationMinutes) {
		super();
		this.title = title;
		this.duration = new Time(durationHours, durationMinutes);
	}
	
	public Movie(String title, int durationMinutes) {
		this(title, Time.newByMin.apply(durationMinutes));
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(duration, other.duration)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "\nMovie [title=" + title + ", duration=" + duration + "]";
	}

}
