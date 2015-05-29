package com.sarojaba.stopwatch;

import static org.junit.Assert.*;

import org.junit.Test;

public class StopwatchTest {

	@Test
	public void testMiliTime() {

		long delay = Stopwatch.task(StopwatchTest::delay500ms).mili().time();

		assertTrue(delay > 450);
		assertTrue(delay < 550);
	}

	@Test
	public void testMiliTimeMulti() {

		long delay = Stopwatch.task(StopwatchTest::delay500ms, 2).mili().time();

		assertTrue(delay > 900);
		assertTrue(delay < 1100);
	}

	@Test
	public void testNanoTime() {

		long delay = Stopwatch.task(StopwatchTest::delay500ms).nano().time();

		assertTrue(delay > 450000000);
		assertTrue(delay < 550000000);
	}

	@Test
	public void testNanoTimeMulti() {

		long delay = Stopwatch.task(StopwatchTest::delay500ms, 2).nano().time();

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

	@Test
	public void testRunnable() {

		Runnable tooSlowOperation = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		long delay = Stopwatch.task(tooSlowOperation).mili().time();

		assertTrue(delay > 900);
		assertTrue(delay < 1100);
	}

	@Test
	public void testMainnable() {

		long delay = Stopwatch.task(Sample::main).mili().time();

		assertTrue(delay > 900);
		assertTrue(delay < 1100);
		
		System.out.println(Stopwatch.task(Sample::main).nano());
	}
}

class Sample {
	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
