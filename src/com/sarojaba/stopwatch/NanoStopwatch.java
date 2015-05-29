package com.sarojaba.stopwatch;

/**
 * stopwatch for nano-seconds
 * 
 * @author sarojaba
 *
 */
public class NanoStopwatch extends AbstractStopwatch {

	@Override
	protected long sysTime() {
		return System.nanoTime();
	}
	
	@Override
	public String toString() {
		return super.toString() + " ns";
	}
}
