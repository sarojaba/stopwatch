package com.sarojaba.stopwatch;

public abstract class Task {

	private int count;

	public void count(int count) {
		this.count = count;
	}

	public void execute() {
		for (int i = 0; i < count; i++) {
			execute0();
		}
	}

	protected abstract void execute0();
}
