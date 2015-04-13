package com.sarojaba.stopwatch;

/**
 * stopwatch for nano-seconds
 * 
 * @author sarojaba
 *
 */
public class NanoStopwatch extends Stopwatch {

	@Override
	protected long sysTime() {
		return System.nanoTime();
	}

}
