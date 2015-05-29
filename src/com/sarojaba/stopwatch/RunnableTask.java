package com.sarojaba.stopwatch;

public class RunnableTask extends Task {

	private Runnable runnable;

	public RunnableTask(Runnable runnable) {
		this.runnable = runnable;
		count(1);
	}

	@Override
	protected void execute0() {
		runnable.run();		
	}

}
