package com.sarojaba.stopwatch;

import java.util.LinkedList;
import java.util.List;

public class StopwatchBuilder {

	List<Task> tasks = new LinkedList<>();

	public StopwatchBuilder task(Runnable runnable) {
		return task(runnable, 1);
	}

	public StopwatchBuilder task(Runnable runnable, int count) {

		Task task = new RunnableTask(runnable);
		task.count(count);

		tasks.add(task);

		return this;
	}

	public StopwatchBuilder task(Mainnable mainnable) {
		return task(mainnable, 1);
	}

	public StopwatchBuilder task(Mainnable mainnable, int count) {
		return task(mainnable, 1, new String[0]);
	}

	public StopwatchBuilder task(Mainnable mainnable, int count, String... args) {

		Task task = new MainnableTask(mainnable, args);
		task.count(count);

		tasks.add(task);

		return this;
	}

	/* factory method */

	public AbstractStopwatch mili() {
		return time(new MiliStopwatch());
	}

	public AbstractStopwatch nano() {
		return time(new NanoStopwatch());
	}
	
	public AbstractStopwatch time(AbstractStopwatch stopwatch) {
		
		long start = stopwatch.sysTime();
		
		tasks.forEach(Task::execute);
		
		long end = stopwatch.sysTime();
		
		stopwatch.time(end - start);
		
		return stopwatch;
	}
}
