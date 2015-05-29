package com.sarojaba.stopwatch;

public class Stopwatch {

	/* easy-use method */

	public static StopwatchBuilder task(Runnable runnable) {
		return task(runnable, 1);
	}

	public static StopwatchBuilder task(Runnable runnable, int count) {
		return new StopwatchBuilder().task(runnable, count);
	}

	public static StopwatchBuilder task(Mainnable mainnable) {
		return task(mainnable, 1);
	}

	public static StopwatchBuilder task(Mainnable mainnable, int count) {
		return task(mainnable, count, new String[0]);
	}

	public static StopwatchBuilder task(Mainnable mainnable, String... args) {
		return task(mainnable, 1, args);
	}

	public static StopwatchBuilder task(Mainnable mainnable, int count,
			String... args) {
		return new StopwatchBuilder().task(mainnable, count, args);
	}
}
