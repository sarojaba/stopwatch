package com.sarojaba.stopwatch;

/**
 * stopwatch for mili-seconds
 * 
 * @author sarojaba
 *
 */
public class MiliStopwatch extends AbstractStopwatch {

	@Override
	protected long sysTime() {
		return System.currentTimeMillis();
	}
	
	@Override
	public String toString() {
		return super.toString() + " ms";
	}
}
