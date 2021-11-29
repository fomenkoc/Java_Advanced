package com.gmail.fomenkoc.homeworks.homework24.classes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeTest {

	private Time time;

	@Before
	public void beforeTest() {
		time = new Time(12, 0);
	}

	@After
	public void afterTest() {
		time = null;
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
	public void calcNewTimeTest() {
		Time actual = time.calcNewTime(time, new Time(1, 30));
		Time expected = new Time(13, 30);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void timeToMinutesTest() {
		int actual = time.timeToMinutes.apply(time);
		int expected = 720;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void newByMinTest() {
		Time actual = Time.newByMin.apply(720);
		Time expected = time;
		Assert.assertEquals(expected, actual);
	}
}
