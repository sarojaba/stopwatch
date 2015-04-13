package com.sarojaba.stopwatch;

/**
 * stopwatch for mili-seconds
 * 
 * @author sarojaba
 *
 */
public class MiliStopwatch extends Stopwatch {

	@Override
	protected long sysTime() {
		return System.currentTimeMillis();
	}
}
