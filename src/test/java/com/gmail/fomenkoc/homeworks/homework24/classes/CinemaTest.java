package com.gmail.fomenkoc.homeworks.homework24.classes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CinemaTest {

	private Cinema cinema;

	@Before
	public void before() {
		cinema = new Cinema();
	}

	@After
	public void after() {
		cinema = null;
	}

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void succeeded(Description description) {
			System.out.println("OK   ---> " + description.getMethodName());
		};

		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("FAIL ---> " + description.getMethodName());
		};
	};

	@Test(expected = IllegalArgumentException.class)
	public void addSeanceTestDayException() {
		Movie movie = new Movie("TestMovie", 120);
		Time time = new Time(12, 0);
		Seance seance = new Seance(movie, time);
		cinema.addSeance(seance, "WrongDay");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeSeanceTestDayException() {
		Movie movie = new Movie("TestMovie", 120);
		Time time = new Time(12, 0);
		Seance seance = new Seance(movie, time);
		cinema.removeSeance(seance, "WrongDay");
	}
	
	@Test
	public void addMovieTest() {
		int excpectedSize = cinema.getMoviesLibrary().size() + 1;
		cinema.addMovie("TestMovie", 120);
		int actualSize = cinema.getMoviesLibrary().size();
		Assert.assertEquals(excpectedSize, actualSize);
	}
	
	@Test
	public void addSeanceTest() {
		int excpectedSize = cinema.getSchedules().size() + 1;
		Movie movie = new Movie("TestMovie", 120);
		Time time = new Time(12, 0);
		Seance seance = new Seance(movie, time);
		cinema.addSeance(seance, "Monday");
		int actualSize = cinema.getSchedules().size();
		Assert.assertEquals(excpectedSize, actualSize);
	}
}
