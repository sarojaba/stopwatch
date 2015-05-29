package com.sarojaba.stopwatch;

public class MainnableTask extends Task {

	private Mainnable mainnable;
	private String[] args;

	public MainnableTask(Mainnable mainnable, String... args) {
		this.mainnable = mainnable;
		this.args = args;
		count(1);
	}

	@Override
	public void execute0() {
		mainnable.main(args);
	}
}
