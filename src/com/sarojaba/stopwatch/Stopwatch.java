package com.sarojaba.stopwatch;

/**
 * Stopwatch class
 * 
 * @author sarojaba
 *
 */
public abstract class Stopwatch {
	
	/* factory method */
	
	public static Stopwatch mili() {
		return new MiliStopwatch();
	}

	public static Stopwatch nano() {
		return new NanoStopwatch();
	}
	
	/* easy-use method */

	public static long mili(Runnable runnable) {
		return mili().time(runnable);
	}

	public static long mili(Runnable runnable, int loop) {
		return mili().time(runnable, loop);
	}
	
	public static long nano(Runnable runnable) {
		return nano().time(runnable);
	}

	public static long nano(Runnable runnable, int loop) {
		return nano().time(runnable, loop);
	}
	
	/* implement */

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
