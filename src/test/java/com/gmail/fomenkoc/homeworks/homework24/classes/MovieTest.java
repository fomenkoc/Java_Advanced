package com.gmail.fomenkoc.homeworks.homework24.classes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class MovieTest {
	private Movie movie;

	@Before
	public void before() {
		Time time = new Time(2, 0);
		movie = new Movie("TestMovie", time);
	}

	@After
	public void after() {
		movie = null;
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

	@Test
	public void movieTestLightConstructor() {
		Movie movieLight = new Movie("TestMovie", 2, 0);
		Assert.assertEquals(movie, movieLight);
	}
	
	@Test
	public void movieTestMinConstructor() {
		Movie movieLight = new Movie("TestMovie", 120);
		Assert.assertEquals(movie, movieLight);
	}

}
