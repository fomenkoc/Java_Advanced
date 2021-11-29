package com.gmail.fomenkoc.homeworks.homework24.classes;

import java.util.Objects;

public class Seance implements Comparable<Seance>{
	private Movie movie;
	private Time startTime;
	private Time endTime;

	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = startTime.calcNewTime(startTime, movie.getDuration());
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endTime, movie, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(endTime, other.endTime)
				&& Objects.equals(movie, other.movie)
				&& Objects.equals(startTime, other.startTime);
	}

	@Override
	public String toString() {
		return "\nSeance [" + movie + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(Seance o) {
		
		if ((this.startTime.timeToMinutes.apply(this.startTime)) 
				> 
			(o.startTime.timeToMinutes.apply(o.startTime))) {
			return 1;
		} else if ((this.startTime.timeToMinutes.apply(this.startTime)) 
						< 
					(o.startTime.timeToMinutes.apply(o.startTime))) {
			return -1;
		} else
		return 0;
	}

}
