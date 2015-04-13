package com.sarojaba.stopwatch;

/**
 * Stopwatch class
 * 
 * @author sarojaba
 *
 */
public abstract class Stopwatch {

	public static Stopwatch mili() {
		return new MiliStopwatch();
	}

	public static Stopwatch nano() {
		return new NanoStopwatch();
	}

	abstract protected long sysTime();

	public long time(Runnable runnable) {

		long start = sysTime();

		runnable.run();

		long end = sysTime();

		return end - start;
	}

	public long time(Runnable runnable, int loop) {

		long start = sysTime();

		for (int i = 0; i < loop; i++) {
			runnable.run();
		}

		long end = sysTime();

		return end - start;
	}
}
