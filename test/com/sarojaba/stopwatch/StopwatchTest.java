package com.sarojaba.stopwatch;

import static org.junit.Assert.*;

import org.junit.Test;

public class StopwatchTest {

	@Test
	public void testMiliTime() {

		long delay = Stopwatch.mili().time(StopwatchTest::delay500ms);

		assertTrue(delay > 450);
		assertTrue(delay < 550);
	}

	@Test
	public void testMiliTimeMulti() {

		long delay = Stopwatch.mili().time(StopwatchTest::delay500ms, 2);

		assertTrue(delay > 900);
		assertTrue(delay < 1100);
	}

	@Test
	public void testNanoTime() {

		long delay = Stopwatch.nano().time(StopwatchTest::delay500ms);

		assertTrue(delay > 450000000);
		assertTrue(delay < 550000000);
	}

	@Test
	public void testNanoTimeMulti() {

		long delay = Stopwatch.nano().time(StopwatchTest::delay500ms, 2);

		assertTrue(delay > 900000000);
		assertTrue(delay < 1100000000);
	}

	/**
	 * delay while 500 mili-second
	 */
	public static void delay500ms() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
