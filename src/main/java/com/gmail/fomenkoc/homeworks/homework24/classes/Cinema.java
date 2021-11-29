package com.gmail.fomenkoc.homeworks.homework24.classes;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.gmail.fomenkoc.homeworks.homework24.enums.Days;

public class Cinema {
	private TreeMap<Days, Schedule> schedules;
	private ArrayList<Movie> moviesLibrary;
	private Time open;
	private Time close;
	
	private BiPredicate<Time, Time> isCinemaOpen = 
			(bt, et) -> bt.timeToMinutes.apply(bt) >= this.open.timeToMinutes
					.apply(getOpen())
					&& et.timeToMinutes.apply(et) <= this.close.timeToMinutes
							.apply(getClose());
			
	public Function<String, Movie> getMovieByName = t -> getMoviesLibrary()
			.stream().filter(m -> m.getTitle().equalsIgnoreCase(t)).findFirst()
			.get();
	
	public Cinema() {
		super();
		this.schedules = new TreeMap<Days, Schedule>();
		this.moviesLibrary = new ArrayList<Movie>();
		this.open = new Time(9, 0);
		this.close = new Time(22, 0);
	}
	
	public Cinema(TreeMap<Days, Schedule> schedules,
			ArrayList<Movie> moviesLibrary, Time open, Time close) {
		super();
		this.schedules = schedules;
		this.moviesLibrary = moviesLibrary;
		this.open = open;
		this.close = close;
	}
	
	public void addMovie(Movie movie) {
		this.moviesLibrary.add(movie);
	}
	
	public void addMovie(String movieTitle, int min) {
		this.moviesLibrary.add(new Movie(movieTitle, Time.newByMin.apply(min)));
	}

	public void addSeance(Seance seance, String dayStr) {
		Days day;
		if (Days.isCorrect.test(dayStr)) {
			day = Days.valueOf(dayStr.toUpperCase());
			
		} else {
			throw new IllegalArgumentException("\"" + dayStr 
									+ "\" is incorrect day name!");
		}
		
		if (isCinemaOpen.test(seance.getStartTime(), seance.getEndTime())) {

			if (this.schedules.get(day) != null) {
				this.schedules.get(day).addSeance(seance);
			} else {

				Schedule schedule = new Schedule();
				schedule.addSeance(seance);
				this.schedules.put(day, schedule);
			}
		} else {
			System.out.println("The cinema works from " + this.getOpen()
					+ " to " + this.getClose());
		}
	}
	
	public void removeMovie(Movie movie) {
		setMoviesLibrary((ArrayList<Movie>) this.moviesLibrary.stream()
				.filter(m -> !m.equals(movie)).collect(Collectors.toList()));

		for (Days day : Days.values()) {
			if (this.schedules.get(day) != null)
				this.schedules.get(day).getSeances()
									.removeIf(s -> s.getMovie().equals(movie));
		}
	}
	
	public void removeSeance(Seance seance, String dayStr) {
		Days day;
		if (Days.isCorrect.test(dayStr)) {
			day = Days.valueOf(dayStr.toUpperCase());

		} else {
			throw new IllegalArgumentException(
					"\"" + dayStr + "\" is incorrect day name!");
		}
		if (this.schedules.get(day) != null)
			this.schedules.get(day).getSeances()
										.removeIf(s -> s.equals(seance));
	}
	
	public void fillTestData() {
		this.moviesLibrary = new ArrayList<Movie>();
		this.addMovie(new Movie("Batman Bigins", 140));
		this.addMovie(new Movie("The Dark Knight", 152));
		this.addMovie(new Movie("The Dark Knight Rises", 165));
		this.addMovie(new Movie("Man of Steel", 143));
		this.addMovie(new Movie("Batman v Superman: Dawn of Justice", 152));
		this.addMovie(new Movie("Suicide Squad", 123));
		this.addMovie(new Movie("Wonder Woman", 141));
		this.addMovie(new Movie("Justice League", 120));
		this.addMovie(new Movie("Zack Snyder's Justice League", 242));
		this.addMovie(new Movie("Aquaman", 143));
		this.addMovie(new Movie("Shazam!", 132));
		this.addMovie(new Movie("Birds of Prey", 109));
		this.addMovie(new Movie("Wonder Woman 1984", 151));
		this.addMovie(new Movie("The Suicide Squad", 132));
		
		this.schedules = new TreeMap<Days, Schedule>();
		
		Seance seance = new Seance(this.moviesLibrary.get(0), new Time(9, 0));
		this.addSeance(seance, "Monday");
		seance = new Seance(this.moviesLibrary.get(1), new Time(11, 45));
		this.addSeance(seance, "Monday");
		seance = new Seance(this.moviesLibrary.get(2), new Time(14, 30));
		this.addSeance(seance, "Monday");
		seance = new Seance(this.moviesLibrary.get(3), new Time(17, 30));
		this.addSeance(seance, "Monday");
		seance = new Seance(this.moviesLibrary.get(7), new Time(20, 00));
		this.addSeance(seance, "Monday");
		
		seance = new Seance(this.moviesLibrary.get(4), new Time(9, 00));
		this.addSeance(seance, "Tuesday");
		seance = new Seance(this.moviesLibrary.get(5), new Time(11, 45));
		this.addSeance(seance, "Tuesday");
		seance = new Seance(this.moviesLibrary.get(6), new Time(14, 00));
		this.addSeance(seance, "Tuesday");
		seance = new Seance(this.moviesLibrary.get(8), new Time(16, 30));
		this.addSeance(seance, "Tuesday");
		
		seance = new Seance(this.moviesLibrary.get(9), new Time(9, 00));
		this.addSeance(seance, "Wednesday");
		seance = new Seance(this.moviesLibrary.get(10), new Time(12, 45));
		this.addSeance(seance, "Wednesday");
		seance = new Seance(this.moviesLibrary.get(11), new Time(15, 30));
		this.addSeance(seance, "Wednesday");
		seance = new Seance(this.moviesLibrary.get(12), new Time(17, 30));
		this.addSeance(seance, "Wednesday");
		
		seance = new Seance(this.moviesLibrary.get(13), new Time(9, 00));
		this.addSeance(seance, "Thursday");
		seance = new Seance(this.moviesLibrary.get(0), new Time(11, 30));
		this.addSeance(seance, "Thursday");
		seance = new Seance(this.moviesLibrary.get(1), new Time(14, 00));
		this.addSeance(seance, "Thursday");
		seance = new Seance(this.moviesLibrary.get(2), new Time(17, 00));
		this.addSeance(seance, "Thursday");
		
		seance = new Seance(this.moviesLibrary.get(3), new Time(9, 00));
		this.addSeance(seance, "Friday");
		seance = new Seance(this.moviesLibrary.get(4), new Time(12, 00));
		this.addSeance(seance, "Friday");
		seance = new Seance(this.moviesLibrary.get(5), new Time(15, 00));
		this.addSeance(seance, "Friday");
		seance = new Seance(this.moviesLibrary.get(6), new Time(17, 30));
		this.addSeance(seance, "Friday");
		
		seance = new Seance(this.moviesLibrary.get(7), new Time(9, 00));
		this.addSeance(seance, "Saturday");
		seance = new Seance(this.moviesLibrary.get(8), new Time(11, 30));
		this.addSeance(seance, "Saturday");
		seance = new Seance(this.moviesLibrary.get(9), new Time(16, 00));
		this.addSeance(seance, "Saturday");
		seance = new Seance(this.moviesLibrary.get(10), new Time(19, 00));
		this.addSeance(seance, "Saturday");
		
		seance = new Seance(this.moviesLibrary.get(11), new Time(9, 00));
		this.addSeance(seance, "Sunday");
		seance = new Seance(this.moviesLibrary.get(12), new Time(11, 00));
		this.addSeance(seance, "Sunday");
		seance = new Seance(this.moviesLibrary.get(13), new Time(14, 00));
		this.addSeance(seance, "Sunday");
		seance = new Seance(this.moviesLibrary.get(0), new Time(17, 00));
		this.addSeance(seance, "Sunday");
		
	}
	
	public void showLibrary() {
		System.out.println("id\tTitle");
		for (int i = 0; i < this.moviesLibrary.size(); i++) {
			System.out.println(i +"\t" + this.moviesLibrary.get(i).getTitle());
		}
	}
	
	public void showAllSeances() {
		for (Days day : Days.values()) {
			System.out.println("\n" + day + ":");
			System.out.println(this.getSchedules().get(day).toString());
		}
	}
	
	public void showSeancesByDay(String dayStr) {
		Days day = null;
		if (Days.isCorrect.test(dayStr)) {
			day = Days.valueOf(dayStr.toUpperCase());
		}
		System.out.println(this.schedules.get(day).toString());
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}


	public void setSchedules(TreeMap<Days, Schedule> schedules) {
		this.schedules = schedules;
	}


	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}


	public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
		this.moviesLibrary = moviesLibrary;
	}


	public Time getOpen() {
		return open;
	}


	public void setOpen(Time open) {
		this.open = open;
	}


	public Time getClose() {
		return close;
	}


	public void setClose(Time close) {
		this.close = close;
	}


	@Override
	public int hashCode() {
		return Objects.hash(close, moviesLibrary, open, schedules);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		return Objects.equals(close, other.close)
				&& Objects.equals(moviesLibrary, other.moviesLibrary)
				&& Objects.equals(open, other.open)
				&& Objects.equals(schedules, other.schedules);
	}


	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary="
				+ moviesLibrary + ", open=" + open + ", close=" + close + "]";
	}
	
	

}
